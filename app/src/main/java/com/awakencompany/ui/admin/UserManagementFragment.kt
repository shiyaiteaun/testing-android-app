package com.awakencompany.ui.admin

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.User
import com.awakencompany.databinding.FragmentUserManagementBinding
import com.awakencompany.databinding.DialogAddUserBinding
import com.awakencompany.databinding.ItemUserBinding
import kotlinx.coroutines.launch
import java.security.MessageDigest

class UserManagementFragment : Fragment() {
    private var _binding: FragmentUserManagementBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var adapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserManagementBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UsersAdapter(
            database = database,
            onEdit = { user ->
                showEditDialog(user)
            },
            onDelete = { user ->
                showDeleteDialog(user)
            },
            onToggleStatus = { user ->
                toggleUserStatus(user)
            }
        )

        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewUsers.adapter = adapter

        binding.btnAddUser.setOnClickListener {
            showAddUserDialog()
        }

        binding.btnSearch.setOnClickListener {
            searchUsers()
        }

        loadUsers()
    }

    override fun onResume() {
        super.onResume()
        loadUsers()
    }

    private fun loadUsers() {
        lifecycleScope.launch {
            val users = database.userDao().getAllUsers()
            requireActivity().runOnUiThread {
                adapter.submitList(users)
                if (users.isEmpty()) {
                    binding.emptyView.visibility = View.VISIBLE
                    binding.recyclerViewUsers.visibility = View.GONE
                } else {
                    binding.emptyView.visibility = View.GONE
                    binding.recyclerViewUsers.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun searchUsers() {
        val searchTerm = binding.etSearch.text.toString().trim()
        lifecycleScope.launch {
            val users = if (searchTerm.isEmpty()) {
                database.userDao().getAllUsers()
            } else {
                database.userDao().searchUsers(searchTerm)
            }
            requireActivity().runOnUiThread {
                adapter.submitList(users)
            }
        }
    }

    private fun showAddUserDialog() {
        val dialogBinding = DialogAddUserBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Add New User")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { _, _ ->
                val username = dialogBinding.etUsername.text.toString().trim()
                val password = dialogBinding.etPassword.text.toString().trim()
                val fullName = dialogBinding.etFullName.text.toString().trim()
                val email = dialogBinding.etEmail.text.toString().trim()
                val phone = dialogBinding.etPhone.text.toString().trim()

                if (username.isEmpty() || password.isEmpty() || fullName.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill required fields", Toast.LENGTH_SHORT).show()
                } else {
                    addUser(username, password, fullName, email, phone)
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun addUser(username: String, password: String, fullName: String, email: String, phone: String) {
        lifecycleScope.launch {
            try {
                // Check if username exists
                val existingUser = database.userDao().getUserByUsername(username)
                if (existingUser != null) {
                    requireActivity().runOnUiThread {
                        Toast.makeText(requireContext(), "Username already exists", Toast.LENGTH_SHORT).show()
                    }
                    return@launch
                }

                val hashedPassword = hashPassword(password)
                val user = User(
                    username = username,
                    password = hashedPassword,
                    fullName = fullName,
                    email = if (email.isEmpty()) null else email,
                    phone = if (phone.isEmpty()) null else phone,
                    status = "active"
                )

                database.userDao().insertUser(user)
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "User added successfully", Toast.LENGTH_SHORT).show()
                    loadUsers()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showEditDialog(user: User) {
        val dialogBinding = DialogAddUserBinding.inflate(layoutInflater)
        dialogBinding.etUsername.setText(user.username)
        dialogBinding.etUsername.isEnabled = false
        dialogBinding.etFullName.setText(user.fullName)
        dialogBinding.etEmail.setText(user.email ?: "")
        dialogBinding.etPhone.setText(user.phone ?: "")
        dialogBinding.etPassword.hint = "New Password (leave empty to keep current)"

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Edit User")
            .setView(dialogBinding.root)
            .setPositiveButton("Update") { _, _ ->
                val password = dialogBinding.etPassword.text.toString().trim()
                val fullName = dialogBinding.etFullName.text.toString().trim()
                val email = dialogBinding.etEmail.text.toString().trim()
                val phone = dialogBinding.etPhone.text.toString().trim()

                if (fullName.isEmpty()) {
                    Toast.makeText(requireContext(), "Full name is required", Toast.LENGTH_SHORT).show()
                } else {
                    updateUser(user, password, fullName, email, phone)
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun updateUser(user: User, newPassword: String, fullName: String, email: String, phone: String) {
        lifecycleScope.launch {
            try {
                val hashedPassword = if (newPassword.isNotEmpty()) {
                    hashPassword(newPassword)
                } else {
                    user.password
                }

                val updatedUser = user.copy(
                    password = hashedPassword,
                    fullName = fullName,
                    email = if (email.isEmpty()) null else email,
                    phone = if (phone.isEmpty()) null else phone
                )

                database.userDao().updateUser(updatedUser)
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "User updated successfully", Toast.LENGTH_SHORT).show()
                    loadUsers()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showDeleteDialog(user: User) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete User")
            .setMessage("Are you sure you want to delete user: ${user.username}?")
            .setPositiveButton("Delete") { _, _ ->
                deleteUser(user)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteUser(user: User) {
        lifecycleScope.launch {
            try {
                database.userDao().deleteUser(user)
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "User deleted successfully", Toast.LENGTH_SHORT).show()
                    loadUsers()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun toggleUserStatus(user: User) {
        lifecycleScope.launch {
            try {
                val newStatus = if (user.status == "active") "inactive" else "active"
                val updatedUser = user.copy(status = newStatus)
                database.userDao().updateUser(updatedUser)
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "User status updated", Toast.LENGTH_SHORT).show()
                    loadUsers()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun hashPassword(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val hashBytes = md.digest(password.toByteArray())
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class UsersAdapter(
    private val database: AppDatabase,
    private val onEdit: (User) -> Unit,
    private val onDelete: (User) -> Unit,
    private val onToggleStatus: (User) -> Unit
) : androidx.recyclerview.widget.ListAdapter<User, UsersAdapter.UserViewHolder>(
    UserDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding, onEdit, onDelete, onToggleStatus)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(
        private val binding: ItemUserBinding,
        private val onEdit: (User) -> Unit,
        private val onDelete: (User) -> Unit,
        private val onToggleStatus: (User) -> Unit
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvUsername.text = user.username
            binding.tvFullName.text = user.fullName
            binding.tvEmail.text = user.email ?: "N/A"
            binding.tvPhone.text = user.phone ?: "N/A"
            binding.tvStatus.text = user.status
            binding.tvStatus.setTextColor(
                if (user.status == "active") {
                    android.graphics.Color.parseColor("#4CAF50")
                } else {
                    android.graphics.Color.parseColor("#F44336")
                }
            )

            binding.btnEdit.setOnClickListener {
                onEdit(user)
            }

            binding.btnDelete.setOnClickListener {
                onDelete(user)
            }

            binding.btnToggleStatus.setOnClickListener {
                onToggleStatus(user)
            }
        }
    }

    class UserDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}
