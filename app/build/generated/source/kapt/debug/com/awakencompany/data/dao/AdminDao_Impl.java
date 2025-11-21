package com.awakencompany.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.awakencompany.data.models.Admin;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AdminDao_Impl implements AdminDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Admin> __insertionAdapterOfAdmin;

  private final EntityDeletionOrUpdateAdapter<Admin> __deletionAdapterOfAdmin;

  private final EntityDeletionOrUpdateAdapter<Admin> __updateAdapterOfAdmin;

  public AdminDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAdmin = new EntityInsertionAdapter<Admin>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `admins` (`adminId`,`username`,`password`,`createdAt`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Admin value) {
        stmt.bindLong(1, value.getAdminId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        stmt.bindLong(4, value.getCreatedAt());
      }
    };
    this.__deletionAdapterOfAdmin = new EntityDeletionOrUpdateAdapter<Admin>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `admins` WHERE `adminId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Admin value) {
        stmt.bindLong(1, value.getAdminId());
      }
    };
    this.__updateAdapterOfAdmin = new EntityDeletionOrUpdateAdapter<Admin>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `admins` SET `adminId` = ?,`username` = ?,`password` = ?,`createdAt` = ? WHERE `adminId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Admin value) {
        stmt.bindLong(1, value.getAdminId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        stmt.bindLong(4, value.getCreatedAt());
        stmt.bindLong(5, value.getAdminId());
      }
    };
  }

  @Override
  public Object insertAdmin(final Admin admin, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfAdmin.insertAndReturnId(admin);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAdmin(final Admin admin, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAdmin.handle(admin);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateAdmin(final Admin admin, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAdmin.handle(admin);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAdminByUsername(final String username,
      final Continuation<? super Admin> continuation) {
    final String _sql = "SELECT * FROM admins WHERE username = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Admin>() {
      @Override
      public Admin call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdminId = CursorUtil.getColumnIndexOrThrow(_cursor, "adminId");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Admin _result;
          if(_cursor.moveToFirst()) {
            final int _tmpAdminId;
            _tmpAdminId = _cursor.getInt(_cursorIndexOfAdminId);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Admin(_tmpAdminId,_tmpUsername,_tmpPassword,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAdminById(final int adminId, final Continuation<? super Admin> continuation) {
    final String _sql = "SELECT * FROM admins WHERE adminId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, adminId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Admin>() {
      @Override
      public Admin call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdminId = CursorUtil.getColumnIndexOrThrow(_cursor, "adminId");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Admin _result;
          if(_cursor.moveToFirst()) {
            final int _tmpAdminId;
            _tmpAdminId = _cursor.getInt(_cursorIndexOfAdminId);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Admin(_tmpAdminId,_tmpUsername,_tmpPassword,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllAdmins(final Continuation<? super List<Admin>> continuation) {
    final String _sql = "SELECT * FROM admins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Admin>>() {
      @Override
      public List<Admin> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdminId = CursorUtil.getColumnIndexOrThrow(_cursor, "adminId");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Admin> _result = new ArrayList<Admin>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Admin _item;
            final int _tmpAdminId;
            _tmpAdminId = _cursor.getInt(_cursorIndexOfAdminId);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Admin(_tmpAdminId,_tmpUsername,_tmpPassword,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
