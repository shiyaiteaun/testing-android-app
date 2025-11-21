# 🚀 GitHub Push Guide - All Files

## 📍 Current Location
```
C:\xampp\htdocs\awaken_company\android_app
```

## 🔄 Push All Changes to GitHub

### Step 1: Check Current Status
```powershell
git status
```
ဒါက modified files တွေကို ပြပေးတယ်။

### Step 2: Add All Files
```powershell
# All files (including new files)
git add .

# Or specific files only
git add file1.txt file2.txt
```

### Step 3: Commit Changes
```powershell
git commit -m "Your commit message here"
```

**Good commit messages:**
- `"Fix layout errors and update dependencies"`
- `"Add admin dashboard features"`
- `"Fix GitHub Actions workflow"`

### Step 4: Push to GitHub
```powershell
git push origin main
```

**If using master branch:**
```powershell
git push origin master
```

## 📋 Complete Workflow

### Quick Commands (All-in-One):
```powershell
# 1. Check what changed
git status

# 2. Add all changes
git add .

# 3. Commit with message
git commit -m "Update Android app: Fix layouts and dependencies"

# 4. Push to GitHub
git push origin main
```

## 🔍 Check Current Branch
```powershell
git branch
```
- `* main` = main branch မှာ ရှိနေတယ်
- `* master` = master branch မှာ ရှိနေတယ်

## ⚠️ Common Issues & Solutions

### Issue 1: "No upstream branch"
**Error:**
```
fatal: The current branch main has no upstream branch.
```

**Solution:**
```powershell
git push -u origin main
```
ဒါက first time push အတွက် upstream set လုပ်ပေးတယ်။

### Issue 2: "Updates were rejected"
**Error:**
```
! [rejected]        main -> main (fetch first)
```

**Solution:**
```powershell
# Pull latest changes first
git pull origin main

# Resolve conflicts if any, then push
git push origin main
```

### Issue 3: "Authentication failed"
**Error:**
```
remote: Invalid username or password
```

**Solution:**
- Personal Access Token (PAT) သုံးရမယ်
- Password နဲ့ push လုပ်လို့မရတော့ဘူး

**Create PAT:**
1. GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Generate new token
3. `repo` scope select လုပ်ပါ
4. Token ကို copy လုပ်ပြီး password အစား သုံးပါ

## 🎯 Step-by-Step Example

### Example 1: First Time Push
```powershell
# Navigate to project
cd C:\xampp\htdocs\awaken_company\android_app

# Check status
git status

# Add all files
git add .

# Commit
git commit -m "Initial Android app commit"

# Push (first time)
git push -u origin main
```

### Example 2: Update Existing Files
```powershell
# Check what changed
git status

# Add all changes
git add .

# Commit
git commit -m "Fix layout errors and update dependencies"

# Push
git push origin main
```

### Example 3: Push Specific Files Only
```powershell
# Add specific files
git add app/build.gradle
git add app/src/main/res/layout/fragment_add_item.xml

# Commit
git commit -m "Update build config and layout"

# Push
git push origin main
```

## 📝 Useful Git Commands

### Check Changes:
```powershell
# See what files changed
git status

# See detailed changes
git diff

# See changes in specific file
git diff app/build.gradle
```

### Undo Changes:
```powershell
# Unstage files (before commit)
git reset

# Undo changes in specific file
git checkout -- app/build.gradle

# Undo last commit (keep changes)
git reset --soft HEAD~1
```

### View History:
```powershell
# See commit history
git log

# See commit history (one line)
git log --oneline

# See last 5 commits
git log -5
```

## 🔐 Authentication Methods

### Method 1: Personal Access Token (Recommended)
1. GitHub → Settings → Developer settings → Personal access tokens
2. Generate new token (classic)
3. Select `repo` scope
4. Copy token
5. Push လုပ်တဲ့အခါ password အစား token သုံးပါ

### Method 2: SSH Key
```powershell
# Check if SSH key exists
ls ~/.ssh

# Generate SSH key (if needed)
ssh-keygen -t ed25519 -C "your_email@example.com"

# Add to GitHub: Settings → SSH and GPG keys
```

Then use SSH URL:
```powershell
git remote set-url origin git@github.com:shiyaiteaun/testing-android-app.git
```

### Method 3: GitHub CLI
```powershell
# Install GitHub CLI
# Then authenticate
gh auth login
```

## ✅ Verification

### After Push:
1. GitHub repository page ကို ဖွင့်ပါ
2. Files တွေ update ဖြစ်သွားတာ စစ်ဆေးပါ
3. **Actions** tab မှာ workflow run ကို စစ်ဆေးပါ

## 🎯 Quick Reference

**Most Common Commands:**
```powershell
git add .                    # Add all changes
git commit -m "message"     # Commit changes
git push origin main        # Push to GitHub
```

**Check Status:**
```powershell
git status                  # See what changed
git branch                  # See current branch
git remote -v               # See remote URL
```

**First Time Setup:**
```powershell
git push -u origin main     # Set upstream and push
```

## 📋 Summary

1. ✅ `git add .` - All files add လုပ်ပါ
2. ✅ `git commit -m "message"` - Commit လုပ်ပါ
3. ✅ `git push origin main` - GitHub ကို push လုပ်ပါ

**That's it!** 🎉

