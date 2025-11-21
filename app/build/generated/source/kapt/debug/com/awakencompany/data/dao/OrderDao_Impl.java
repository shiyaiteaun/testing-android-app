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
import com.awakencompany.data.models.Order;
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
public final class OrderDao_Impl implements OrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Order> __insertionAdapterOfOrder;

  private final EntityDeletionOrUpdateAdapter<Order> __deletionAdapterOfOrder;

  private final EntityDeletionOrUpdateAdapter<Order> __updateAdapterOfOrder;

  public OrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrder = new EntityInsertionAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `orders` (`orderId`,`orderDate`,`username`,`customerName`,`customerAddress`,`customerPhone`,`paymentMethod`,`grandTotal`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getOrderId());
        stmt.bindLong(2, value.getOrderDate());
        if (value.getUsername() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsername());
        }
        if (value.getCustomerName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCustomerName());
        }
        if (value.getCustomerAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCustomerAddress());
        }
        if (value.getCustomerPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCustomerPhone());
        }
        if (value.getPaymentMethod() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPaymentMethod());
        }
        stmt.bindDouble(8, value.getGrandTotal());
      }
    };
    this.__deletionAdapterOfOrder = new EntityDeletionOrUpdateAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `orders` WHERE `orderId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getOrderId());
      }
    };
    this.__updateAdapterOfOrder = new EntityDeletionOrUpdateAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `orders` SET `orderId` = ?,`orderDate` = ?,`username` = ?,`customerName` = ?,`customerAddress` = ?,`customerPhone` = ?,`paymentMethod` = ?,`grandTotal` = ? WHERE `orderId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getOrderId());
        stmt.bindLong(2, value.getOrderDate());
        if (value.getUsername() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsername());
        }
        if (value.getCustomerName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCustomerName());
        }
        if (value.getCustomerAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCustomerAddress());
        }
        if (value.getCustomerPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCustomerPhone());
        }
        if (value.getPaymentMethod() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPaymentMethod());
        }
        stmt.bindDouble(8, value.getGrandTotal());
        stmt.bindLong(9, value.getOrderId());
      }
    };
  }

  @Override
  public Object insertOrder(final Order order, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfOrder.insertAndReturnId(order);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteOrder(final Order order, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOrder.handle(order);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateOrder(final Order order, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfOrder.handle(order);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllOrders(final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getOrderById(final int orderId, final Continuation<? super Order> continuation) {
    final String _sql = "SELECT * FROM orders WHERE orderId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, orderId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Order>() {
      @Override
      public Order call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final Order _result;
          if(_cursor.moveToFirst()) {
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _result = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getOrdersByUsername(final String username,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE username = ? ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getOrdersByDateRange(final long startDate, final long endDate,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE orderDate >= ? AND orderDate <= ? ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getOrdersByUsernameAndDateRange(final String username, final long startDate,
      final long endDate, final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE username = ? AND orderDate >= ? AND orderDate <= ? ORDER BY orderDate DESC";
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
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getTodayOrders(final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE date(orderDate/1000, 'unixepoch') = date('now') ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getTodayOrdersByUsername(final String username,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE username = ? AND date(orderDate/1000, 'unixepoch') = date('now') ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getWeeklyOrders(final long weekStart, final long weekEnd,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE orderDate >= ? AND orderDate <= ? ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, weekStart);
    _argIndex = 2;
    _statement.bindLong(_argIndex, weekEnd);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getMonthlyOrders(final String yearMonth,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE strftime('%Y-%m', datetime(orderDate/1000, 'unixepoch')) = ? ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (yearMonth == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, yearMonth);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
  public Object getAnnualOrders(final String year,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM orders WHERE strftime('%Y', datetime(orderDate/1000, 'unixepoch')) = ? ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "customerAddress");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfGrandTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "grandTotal");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerAddress;
            if (_cursor.isNull(_cursorIndexOfCustomerAddress)) {
              _tmpCustomerAddress = null;
            } else {
              _tmpCustomerAddress = _cursor.getString(_cursorIndexOfCustomerAddress);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final double _tmpGrandTotal;
            _tmpGrandTotal = _cursor.getDouble(_cursorIndexOfGrandTotal);
            _item = new Order(_tmpOrderId,_tmpOrderDate,_tmpUsername,_tmpCustomerName,_tmpCustomerAddress,_tmpCustomerPhone,_tmpPaymentMethod,_tmpGrandTotal);
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
