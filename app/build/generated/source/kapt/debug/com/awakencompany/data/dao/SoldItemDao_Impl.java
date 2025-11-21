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
import com.awakencompany.data.models.SoldItem;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
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
public final class SoldItemDao_Impl implements SoldItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SoldItem> __insertionAdapterOfSoldItem;

  private final EntityDeletionOrUpdateAdapter<SoldItem> __deletionAdapterOfSoldItem;

  private final EntityDeletionOrUpdateAdapter<SoldItem> __updateAdapterOfSoldItem;

  public SoldItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSoldItem = new EntityInsertionAdapter<SoldItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `sold_items` (`saleId`,`itemCode`,`itemName`,`quantitySold`,`unitPrice`,`totalPrice`,`saleDate`,`username`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SoldItem value) {
        stmt.bindLong(1, value.getSaleId());
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemName());
        }
        stmt.bindLong(4, value.getQuantitySold());
        stmt.bindDouble(5, value.getUnitPrice());
        stmt.bindDouble(6, value.getTotalPrice());
        stmt.bindLong(7, value.getSaleDate());
        if (value.getUsername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUsername());
        }
      }
    };
    this.__deletionAdapterOfSoldItem = new EntityDeletionOrUpdateAdapter<SoldItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `sold_items` WHERE `saleId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SoldItem value) {
        stmt.bindLong(1, value.getSaleId());
      }
    };
    this.__updateAdapterOfSoldItem = new EntityDeletionOrUpdateAdapter<SoldItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `sold_items` SET `saleId` = ?,`itemCode` = ?,`itemName` = ?,`quantitySold` = ?,`unitPrice` = ?,`totalPrice` = ?,`saleDate` = ?,`username` = ? WHERE `saleId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SoldItem value) {
        stmt.bindLong(1, value.getSaleId());
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemName());
        }
        stmt.bindLong(4, value.getQuantitySold());
        stmt.bindDouble(5, value.getUnitPrice());
        stmt.bindDouble(6, value.getTotalPrice());
        stmt.bindLong(7, value.getSaleDate());
        if (value.getUsername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUsername());
        }
        stmt.bindLong(9, value.getSaleId());
      }
    };
  }

  @Override
  public Object insertSoldItem(final SoldItem soldItem,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfSoldItem.insertAndReturnId(soldItem);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteSoldItem(final SoldItem soldItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSoldItem.handle(soldItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateSoldItem(final SoldItem soldItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSoldItem.handle(soldItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllSoldItems(final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getSoldItemById(final int saleId,
      final Continuation<? super SoldItem> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE saleId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, saleId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SoldItem>() {
      @Override
      public SoldItem call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final SoldItem _result;
          if(_cursor.moveToFirst()) {
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _result = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getSoldItemsByUsername(final String username,
      final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE username = ? ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getSoldItemsByDateRange(final long startDate, final long endDate,
      final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE saleDate >= ? AND saleDate <= ? ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getSoldItemsByUsernameAndDateRange(final String username, final long startDate,
      final long endDate, final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE username = ? AND saleDate >= ? AND saleDate <= ? ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getTodaySoldItems(final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE date(saleDate/1000, 'unixepoch') = date('now') ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getTodaySoldItemsByUsername(final String username,
      final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE username = ? AND date(saleDate/1000, 'unixepoch') = date('now') ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getTotalSales(final Continuation<? super Double> continuation) {
    final String _sql = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public Object getTotalTransactions(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(COUNT(*), 0) FROM sold_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getTotalItemsSold(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getTotalSalesByDateRange(final long startDate, final long endDate,
      final Continuation<? super Double> continuation) {
    final String _sql = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE saleDate >= ? AND saleDate <= ?";
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
  public Object getTotalTransactionsByDateRange(final long startDate, final long endDate,
      final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE saleDate >= ? AND saleDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getTotalItemsSoldByDateRange(final long startDate, final long endDate,
      final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE saleDate >= ? AND saleDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getTotalSalesByUsernameAndDateRange(final String username, final long startDate,
      final long endDate, final Continuation<? super Double> continuation) {
    final String _sql = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE username = ? AND saleDate >= ? AND saleDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 3;
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
  public Object getTotalTransactionsByUsernameAndDateRange(final String username,
      final long startDate, final long endDate, final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE username = ? AND saleDate >= ? AND saleDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getTotalItemsSoldByUsernameAndDateRange(final String username, final long startDate,
      final long endDate, final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE username = ? AND saleDate >= ? AND saleDate <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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
  public Object getSoldItemsByMonth(final String yearMonth,
      final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE strftime('%Y-%m', datetime(saleDate/1000, 'unixepoch')) = ? ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (yearMonth == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, yearMonth);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
  public Object getSoldItemsByYear(final String year,
      final Continuation<? super List<SoldItem>> continuation) {
    final String _sql = "SELECT * FROM sold_items WHERE strftime('%Y', datetime(saleDate/1000, 'unixepoch')) = ? ORDER BY saleDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SoldItem>>() {
      @Override
      public List<SoldItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSaleId = CursorUtil.getColumnIndexOrThrow(_cursor, "saleId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfQuantitySold = CursorUtil.getColumnIndexOrThrow(_cursor, "quantitySold");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfSaleDate = CursorUtil.getColumnIndexOrThrow(_cursor, "saleDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final List<SoldItem> _result = new ArrayList<SoldItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SoldItem _item;
            final int _tmpSaleId;
            _tmpSaleId = _cursor.getInt(_cursorIndexOfSaleId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final int _tmpQuantitySold;
            _tmpQuantitySold = _cursor.getInt(_cursorIndexOfQuantitySold);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final long _tmpSaleDate;
            _tmpSaleDate = _cursor.getLong(_cursorIndexOfSaleDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            _item = new SoldItem(_tmpSaleId,_tmpItemCode,_tmpItemName,_tmpQuantitySold,_tmpUnitPrice,_tmpTotalPrice,_tmpSaleDate,_tmpUsername);
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
