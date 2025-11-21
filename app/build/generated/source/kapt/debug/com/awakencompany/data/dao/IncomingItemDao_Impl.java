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
import com.awakencompany.data.models.IncomingItem;
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
public final class IncomingItemDao_Impl implements IncomingItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IncomingItem> __insertionAdapterOfIncomingItem;

  private final EntityDeletionOrUpdateAdapter<IncomingItem> __deletionAdapterOfIncomingItem;

  private final EntityDeletionOrUpdateAdapter<IncomingItem> __updateAdapterOfIncomingItem;

  public IncomingItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncomingItem = new EntityInsertionAdapter<IncomingItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `incoming_items` (`incomingId`,`itemCode`,`quantityAdded`,`purchasePrice`,`incomingDate`,`supplier`,`invoiceNo`,`location`,`remarks`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingItem value) {
        stmt.bindLong(1, value.getIncomingId());
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        stmt.bindLong(3, value.getQuantityAdded());
        stmt.bindDouble(4, value.getPurchasePrice());
        stmt.bindLong(5, value.getIncomingDate());
        if (value.getSupplier() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSupplier());
        }
        if (value.getInvoiceNo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getInvoiceNo());
        }
        if (value.getLocation() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLocation());
        }
        if (value.getRemarks() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarks());
        }
      }
    };
    this.__deletionAdapterOfIncomingItem = new EntityDeletionOrUpdateAdapter<IncomingItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `incoming_items` WHERE `incomingId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingItem value) {
        stmt.bindLong(1, value.getIncomingId());
      }
    };
    this.__updateAdapterOfIncomingItem = new EntityDeletionOrUpdateAdapter<IncomingItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `incoming_items` SET `incomingId` = ?,`itemCode` = ?,`quantityAdded` = ?,`purchasePrice` = ?,`incomingDate` = ?,`supplier` = ?,`invoiceNo` = ?,`location` = ?,`remarks` = ? WHERE `incomingId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingItem value) {
        stmt.bindLong(1, value.getIncomingId());
        if (value.getItemCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemCode());
        }
        stmt.bindLong(3, value.getQuantityAdded());
        stmt.bindDouble(4, value.getPurchasePrice());
        stmt.bindLong(5, value.getIncomingDate());
        if (value.getSupplier() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSupplier());
        }
        if (value.getInvoiceNo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getInvoiceNo());
        }
        if (value.getLocation() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLocation());
        }
        if (value.getRemarks() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarks());
        }
        stmt.bindLong(10, value.getIncomingId());
      }
    };
  }

  @Override
  public Object insertIncomingItem(final IncomingItem incomingItem,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfIncomingItem.insertAndReturnId(incomingItem);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteIncomingItem(final IncomingItem incomingItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfIncomingItem.handle(incomingItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateIncomingItem(final IncomingItem incomingItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfIncomingItem.handle(incomingItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllIncomingItems(final Continuation<? super List<IncomingItem>> continuation) {
    final String _sql = "SELECT * FROM incoming_items ORDER BY incomingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<IncomingItem>>() {
      @Override
      public List<IncomingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<IncomingItem> _result = new ArrayList<IncomingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IncomingItem _item;
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
  public Object getIncomingItemById(final int incomingId,
      final Continuation<? super IncomingItem> continuation) {
    final String _sql = "SELECT * FROM incoming_items WHERE incomingId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, incomingId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<IncomingItem>() {
      @Override
      public IncomingItem call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final IncomingItem _result;
          if(_cursor.moveToFirst()) {
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _result = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
  public Object getIncomingItemsByItemCode(final String itemCode,
      final Continuation<? super List<IncomingItem>> continuation) {
    final String _sql = "SELECT * FROM incoming_items WHERE itemCode = ? ORDER BY incomingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemCode);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<IncomingItem>>() {
      @Override
      public List<IncomingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<IncomingItem> _result = new ArrayList<IncomingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IncomingItem _item;
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
  public Object getIncomingItemsByDateRange(final long startDate, final long endDate,
      final Continuation<? super List<IncomingItem>> continuation) {
    final String _sql = "SELECT * FROM incoming_items WHERE incomingDate >= ? AND incomingDate <= ? ORDER BY incomingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<IncomingItem>>() {
      @Override
      public List<IncomingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<IncomingItem> _result = new ArrayList<IncomingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IncomingItem _item;
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
  public Object searchIncomingItemsBySupplier(final String supplier,
      final Continuation<? super List<IncomingItem>> continuation) {
    final String _sql = "SELECT * FROM incoming_items WHERE supplier LIKE '%' || ? || '%' ORDER BY incomingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (supplier == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, supplier);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<IncomingItem>>() {
      @Override
      public List<IncomingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<IncomingItem> _result = new ArrayList<IncomingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IncomingItem _item;
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
  public Object searchIncomingItemsByInvoiceNo(final String invoiceNo,
      final Continuation<? super List<IncomingItem>> continuation) {
    final String _sql = "SELECT * FROM incoming_items WHERE invoiceNo LIKE '%' || ? || '%' ORDER BY incomingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (invoiceNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, invoiceNo);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<IncomingItem>>() {
      @Override
      public List<IncomingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIncomingId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantityAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "quantityAdded");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfIncomingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "incomingDate");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfInvoiceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "invoiceNo");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "remarks");
          final List<IncomingItem> _result = new ArrayList<IncomingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IncomingItem _item;
            final int _tmpIncomingId;
            _tmpIncomingId = _cursor.getInt(_cursorIndexOfIncomingId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantityAdded;
            _tmpQuantityAdded = _cursor.getInt(_cursorIndexOfQuantityAdded);
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final long _tmpIncomingDate;
            _tmpIncomingDate = _cursor.getLong(_cursorIndexOfIncomingDate);
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final String _tmpInvoiceNo;
            if (_cursor.isNull(_cursorIndexOfInvoiceNo)) {
              _tmpInvoiceNo = null;
            } else {
              _tmpInvoiceNo = _cursor.getString(_cursorIndexOfInvoiceNo);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpRemarks;
            if (_cursor.isNull(_cursorIndexOfRemarks)) {
              _tmpRemarks = null;
            } else {
              _tmpRemarks = _cursor.getString(_cursorIndexOfRemarks);
            }
            _item = new IncomingItem(_tmpIncomingId,_tmpItemCode,_tmpQuantityAdded,_tmpPurchasePrice,_tmpIncomingDate,_tmpSupplier,_tmpInvoiceNo,_tmpLocation,_tmpRemarks);
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
