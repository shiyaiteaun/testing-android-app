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
import com.awakencompany.data.models.OrderItem;
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
public final class OrderItemDao_Impl implements OrderItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderItem> __insertionAdapterOfOrderItem;

  private final EntityDeletionOrUpdateAdapter<OrderItem> __deletionAdapterOfOrderItem;

  private final EntityDeletionOrUpdateAdapter<OrderItem> __updateAdapterOfOrderItem;

  public OrderItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderItem = new EntityInsertionAdapter<OrderItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `order_items` (`orderItemId`,`orderId`,`itemCode`,`quantity`,`unitPrice`,`total`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderItem value) {
        stmt.bindLong(1, value.getOrderItemId());
        stmt.bindLong(2, value.getOrderId());
        if (value.getItemCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemCode());
        }
        stmt.bindLong(4, value.getQuantity());
        stmt.bindDouble(5, value.getUnitPrice());
        stmt.bindDouble(6, value.getTotal());
      }
    };
    this.__deletionAdapterOfOrderItem = new EntityDeletionOrUpdateAdapter<OrderItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `order_items` WHERE `orderItemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderItem value) {
        stmt.bindLong(1, value.getOrderItemId());
      }
    };
    this.__updateAdapterOfOrderItem = new EntityDeletionOrUpdateAdapter<OrderItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `order_items` SET `orderItemId` = ?,`orderId` = ?,`itemCode` = ?,`quantity` = ?,`unitPrice` = ?,`total` = ? WHERE `orderItemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderItem value) {
        stmt.bindLong(1, value.getOrderItemId());
        stmt.bindLong(2, value.getOrderId());
        if (value.getItemCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemCode());
        }
        stmt.bindLong(4, value.getQuantity());
        stmt.bindDouble(5, value.getUnitPrice());
        stmt.bindDouble(6, value.getTotal());
        stmt.bindLong(7, value.getOrderItemId());
      }
    };
  }

  @Override
  public Object insertOrderItem(final OrderItem orderItem,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfOrderItem.insertAndReturnId(orderItem);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertOrderItems(final List<OrderItem> orderItems,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOrderItem.insert(orderItems);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteOrderItem(final OrderItem orderItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOrderItem.handle(orderItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateOrderItem(final OrderItem orderItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfOrderItem.handle(orderItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getOrderItemsByOrderId(final int orderId,
      final Continuation<? super List<OrderItem>> continuation) {
    final String _sql = "SELECT * FROM order_items WHERE orderId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, orderId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<OrderItem>>() {
      @Override
      public List<OrderItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderItemId");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final List<OrderItem> _result = new ArrayList<OrderItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OrderItem _item;
            final int _tmpOrderItemId;
            _tmpOrderItemId = _cursor.getInt(_cursorIndexOfOrderItemId);
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotal;
            _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            _item = new OrderItem(_tmpOrderItemId,_tmpOrderId,_tmpItemCode,_tmpQuantity,_tmpUnitPrice,_tmpTotal);
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
  public Object getAllOrderItems(final Continuation<? super List<OrderItem>> continuation) {
    final String _sql = "SELECT * FROM order_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<OrderItem>>() {
      @Override
      public List<OrderItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderItemId");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCode");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final List<OrderItem> _result = new ArrayList<OrderItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OrderItem _item;
            final int _tmpOrderItemId;
            _tmpOrderItemId = _cursor.getInt(_cursorIndexOfOrderItemId);
            final int _tmpOrderId;
            _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
            final String _tmpItemCode;
            if (_cursor.isNull(_cursorIndexOfItemCode)) {
              _tmpItemCode = null;
            } else {
              _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpTotal;
            _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            _item = new OrderItem(_tmpOrderItemId,_tmpOrderId,_tmpItemCode,_tmpQuantity,_tmpUnitPrice,_tmpTotal);
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
