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
import com.awakencompany.data.models.FinancialTransaction;
import java.lang.Class;
import java.lang.Double;
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
public final class FinancialTransactionDao_Impl implements FinancialTransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FinancialTransaction> __insertionAdapterOfFinancialTransaction;

  private final EntityDeletionOrUpdateAdapter<FinancialTransaction> __deletionAdapterOfFinancialTransaction;

  private final EntityDeletionOrUpdateAdapter<FinancialTransaction> __updateAdapterOfFinancialTransaction;

  public FinancialTransactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFinancialTransaction = new EntityInsertionAdapter<FinancialTransaction>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `financial_transactions` (`transactionId`,`transactionDate`,`description`,`type`,`amount`,`category`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinancialTransaction value) {
        stmt.bindLong(1, value.getTransactionId());
        stmt.bindLong(2, value.getTransactionDate());
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        stmt.bindDouble(5, value.getAmount());
        if (value.getCategory() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCategory());
        }
      }
    };
    this.__deletionAdapterOfFinancialTransaction = new EntityDeletionOrUpdateAdapter<FinancialTransaction>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `financial_transactions` WHERE `transactionId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinancialTransaction value) {
        stmt.bindLong(1, value.getTransactionId());
      }
    };
    this.__updateAdapterOfFinancialTransaction = new EntityDeletionOrUpdateAdapter<FinancialTransaction>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `financial_transactions` SET `transactionId` = ?,`transactionDate` = ?,`description` = ?,`type` = ?,`amount` = ?,`category` = ? WHERE `transactionId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinancialTransaction value) {
        stmt.bindLong(1, value.getTransactionId());
        stmt.bindLong(2, value.getTransactionDate());
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        stmt.bindDouble(5, value.getAmount());
        if (value.getCategory() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCategory());
        }
        stmt.bindLong(7, value.getTransactionId());
      }
    };
  }

  @Override
  public Object insertTransaction(final FinancialTransaction transaction,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfFinancialTransaction.insertAndReturnId(transaction);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteTransaction(final FinancialTransaction transaction,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFinancialTransaction.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateTransaction(final FinancialTransaction transaction,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFinancialTransaction.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllTransactions(
      final Continuation<? super List<FinancialTransaction>> continuation) {
    final String _sql = "SELECT * FROM financial_transactions ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FinancialTransaction>>() {
      @Override
      public List<FinancialTransaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<FinancialTransaction> _result = new ArrayList<FinancialTransaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FinancialTransaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final long _tmpTransactionDate;
            _tmpTransactionDate = _cursor.getLong(_cursorIndexOfTransactionDate);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new FinancialTransaction(_tmpTransactionId,_tmpTransactionDate,_tmpDescription,_tmpType,_tmpAmount,_tmpCategory);
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

  @Override
  public Object getTransactionById(final int transactionId,
      final Continuation<? super FinancialTransaction> continuation) {
    final String _sql = "SELECT * FROM financial_transactions WHERE transactionId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, transactionId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FinancialTransaction>() {
      @Override
      public FinancialTransaction call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final FinancialTransaction _result;
          if(_cursor.moveToFirst()) {
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final long _tmpTransactionDate;
            _tmpTransactionDate = _cursor.getLong(_cursorIndexOfTransactionDate);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _result = new FinancialTransaction(_tmpTransactionId,_tmpTransactionDate,_tmpDescription,_tmpType,_tmpAmount,_tmpCategory);
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
  public Object getTransactionsByType(final String type,
      final Continuation<? super List<FinancialTransaction>> continuation) {
    final String _sql = "SELECT * FROM financial_transactions WHERE type = ? ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FinancialTransaction>>() {
      @Override
      public List<FinancialTransaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<FinancialTransaction> _result = new ArrayList<FinancialTransaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FinancialTransaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final long _tmpTransactionDate;
            _tmpTransactionDate = _cursor.getLong(_cursorIndexOfTransactionDate);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new FinancialTransaction(_tmpTransactionId,_tmpTransactionDate,_tmpDescription,_tmpType,_tmpAmount,_tmpCategory);
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

  @Override
  public Object getTransactionsByDateRange(final long startDate, final long endDate,
      final Continuation<? super List<FinancialTransaction>> continuation) {
    final String _sql = "SELECT * FROM financial_transactions WHERE transactionDate >= ? AND transactionDate <= ? ORDER BY transactionDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FinancialTransaction>>() {
      @Override
      public List<FinancialTransaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfTransactionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionDate");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<FinancialTransaction> _result = new ArrayList<FinancialTransaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FinancialTransaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final long _tmpTransactionDate;
            _tmpTransactionDate = _cursor.getLong(_cursorIndexOfTransactionDate);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new FinancialTransaction(_tmpTransactionId,_tmpTransactionDate,_tmpDescription,_tmpType,_tmpAmount,_tmpCategory);
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

  @Override
  public Object getTotalIncome(final long startDate, final long endDate,
      final Continuation<? super Double> continuation) {
    final String _sql = "SELECT SUM(amount) FROM financial_transactions WHERE type = 'income' AND transactionDate >= ? AND transactionDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if(_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
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
  public Object getTotalExpense(final long startDate, final long endDate,
      final Continuation<? super Double> continuation) {
    final String _sql = "SELECT SUM(amount) FROM financial_transactions WHERE type = 'expense' AND transactionDate >= ? AND transactionDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if(_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
