package com.awakencompany.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.awakencompany.data.dao.AdminDao;
import com.awakencompany.data.dao.AdminDao_Impl;
import com.awakencompany.data.dao.FinancialTransactionDao;
import com.awakencompany.data.dao.FinancialTransactionDao_Impl;
import com.awakencompany.data.dao.IncomingItemDao;
import com.awakencompany.data.dao.IncomingItemDao_Impl;
import com.awakencompany.data.dao.OrderDao;
import com.awakencompany.data.dao.OrderDao_Impl;
import com.awakencompany.data.dao.OrderItemDao;
import com.awakencompany.data.dao.OrderItemDao_Impl;
import com.awakencompany.data.dao.ProductDao;
import com.awakencompany.data.dao.ProductDao_Impl;
import com.awakencompany.data.dao.SoldItemDao;
import com.awakencompany.data.dao.SoldItemDao_Impl;
import com.awakencompany.data.dao.UserDao;
import com.awakencompany.data.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile AdminDao _adminDao;

  private volatile UserDao _userDao;

  private volatile ProductDao _productDao;

  private volatile OrderDao _orderDao;

  private volatile OrderItemDao _orderItemDao;

  private volatile IncomingItemDao _incomingItemDao;

  private volatile SoldItemDao _soldItemDao;

  private volatile FinancialTransactionDao _financialTransactionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `admins` (`adminId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL, `createdAt` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`userId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL, `fullName` TEXT, `email` TEXT, `phone` TEXT, `status` TEXT NOT NULL, `createdBy` INTEGER, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `products` (`itemCode` TEXT NOT NULL, `itemName` TEXT NOT NULL, `category` TEXT, `unitPrice` REAL NOT NULL, `quantity` INTEGER NOT NULL, `itemPhoto` TEXT, PRIMARY KEY(`itemCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `orders` (`orderId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderDate` INTEGER NOT NULL, `username` TEXT, `customerName` TEXT, `customerAddress` TEXT, `customerPhone` TEXT, `paymentMethod` TEXT NOT NULL, `grandTotal` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `order_items` (`orderItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` INTEGER NOT NULL, `itemCode` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `unitPrice` REAL NOT NULL, `total` REAL NOT NULL, FOREIGN KEY(`orderId`) REFERENCES `orders`(`orderId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`itemCode`) REFERENCES `products`(`itemCode`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `incoming_items` (`incomingId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `itemCode` TEXT NOT NULL, `quantityAdded` INTEGER NOT NULL, `purchasePrice` REAL NOT NULL, `incomingDate` INTEGER NOT NULL, `supplier` TEXT, `invoiceNo` TEXT, `location` TEXT, `remarks` TEXT, FOREIGN KEY(`itemCode`) REFERENCES `products`(`itemCode`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sold_items` (`saleId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `itemCode` TEXT NOT NULL, `itemName` TEXT NOT NULL, `quantitySold` INTEGER NOT NULL, `unitPrice` REAL NOT NULL, `totalPrice` REAL NOT NULL, `saleDate` INTEGER NOT NULL, `username` TEXT, FOREIGN KEY(`itemCode`) REFERENCES `products`(`itemCode`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `financial_transactions` (`transactionId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `transactionDate` INTEGER NOT NULL, `description` TEXT NOT NULL, `type` TEXT NOT NULL, `amount` REAL NOT NULL, `category` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6492d3aa9de124553079ce3592562090')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `admins`");
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        _db.execSQL("DROP TABLE IF EXISTS `products`");
        _db.execSQL("DROP TABLE IF EXISTS `orders`");
        _db.execSQL("DROP TABLE IF EXISTS `order_items`");
        _db.execSQL("DROP TABLE IF EXISTS `incoming_items`");
        _db.execSQL("DROP TABLE IF EXISTS `sold_items`");
        _db.execSQL("DROP TABLE IF EXISTS `financial_transactions`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAdmins = new HashMap<String, TableInfo.Column>(4);
        _columnsAdmins.put("adminId", new TableInfo.Column("adminId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdmins.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdmins.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdmins.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAdmins = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAdmins = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAdmins = new TableInfo("admins", _columnsAdmins, _foreignKeysAdmins, _indicesAdmins);
        final TableInfo _existingAdmins = TableInfo.read(_db, "admins");
        if (! _infoAdmins.equals(_existingAdmins)) {
          return new RoomOpenHelper.ValidationResult(false, "admins(com.awakencompany.data.models.Admin).\n"
                  + " Expected:\n" + _infoAdmins + "\n"
                  + " Found:\n" + _existingAdmins);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(10);
        _columnsUsers.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("fullName", new TableInfo.Column("fullName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdBy", new TableInfo.Column("createdBy", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.awakencompany.data.models.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsProducts = new HashMap<String, TableInfo.Column>(6);
        _columnsProducts.put("itemCode", new TableInfo.Column("itemCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("itemName", new TableInfo.Column("itemName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("itemPhoto", new TableInfo.Column("itemPhoto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProducts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProducts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProducts = new TableInfo("products", _columnsProducts, _foreignKeysProducts, _indicesProducts);
        final TableInfo _existingProducts = TableInfo.read(_db, "products");
        if (! _infoProducts.equals(_existingProducts)) {
          return new RoomOpenHelper.ValidationResult(false, "products(com.awakencompany.data.models.Product).\n"
                  + " Expected:\n" + _infoProducts + "\n"
                  + " Found:\n" + _existingProducts);
        }
        final HashMap<String, TableInfo.Column> _columnsOrders = new HashMap<String, TableInfo.Column>(8);
        _columnsOrders.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("orderDate", new TableInfo.Column("orderDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerName", new TableInfo.Column("customerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerAddress", new TableInfo.Column("customerAddress", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerPhone", new TableInfo.Column("customerPhone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("paymentMethod", new TableInfo.Column("paymentMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("grandTotal", new TableInfo.Column("grandTotal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrders = new TableInfo("orders", _columnsOrders, _foreignKeysOrders, _indicesOrders);
        final TableInfo _existingOrders = TableInfo.read(_db, "orders");
        if (! _infoOrders.equals(_existingOrders)) {
          return new RoomOpenHelper.ValidationResult(false, "orders(com.awakencompany.data.models.Order).\n"
                  + " Expected:\n" + _infoOrders + "\n"
                  + " Found:\n" + _existingOrders);
        }
        final HashMap<String, TableInfo.Column> _columnsOrderItems = new HashMap<String, TableInfo.Column>(6);
        _columnsOrderItems.put("orderItemId", new TableInfo.Column("orderItemId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("itemCode", new TableInfo.Column("itemCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("total", new TableInfo.Column("total", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrderItems = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysOrderItems.add(new TableInfo.ForeignKey("orders", "CASCADE", "NO ACTION",Arrays.asList("orderId"), Arrays.asList("orderId")));
        _foreignKeysOrderItems.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION",Arrays.asList("itemCode"), Arrays.asList("itemCode")));
        final HashSet<TableInfo.Index> _indicesOrderItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrderItems = new TableInfo("order_items", _columnsOrderItems, _foreignKeysOrderItems, _indicesOrderItems);
        final TableInfo _existingOrderItems = TableInfo.read(_db, "order_items");
        if (! _infoOrderItems.equals(_existingOrderItems)) {
          return new RoomOpenHelper.ValidationResult(false, "order_items(com.awakencompany.data.models.OrderItem).\n"
                  + " Expected:\n" + _infoOrderItems + "\n"
                  + " Found:\n" + _existingOrderItems);
        }
        final HashMap<String, TableInfo.Column> _columnsIncomingItems = new HashMap<String, TableInfo.Column>(9);
        _columnsIncomingItems.put("incomingId", new TableInfo.Column("incomingId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("itemCode", new TableInfo.Column("itemCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("quantityAdded", new TableInfo.Column("quantityAdded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("purchasePrice", new TableInfo.Column("purchasePrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("incomingDate", new TableInfo.Column("incomingDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("supplier", new TableInfo.Column("supplier", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("invoiceNo", new TableInfo.Column("invoiceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingItems.put("remarks", new TableInfo.Column("remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncomingItems = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysIncomingItems.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION",Arrays.asList("itemCode"), Arrays.asList("itemCode")));
        final HashSet<TableInfo.Index> _indicesIncomingItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncomingItems = new TableInfo("incoming_items", _columnsIncomingItems, _foreignKeysIncomingItems, _indicesIncomingItems);
        final TableInfo _existingIncomingItems = TableInfo.read(_db, "incoming_items");
        if (! _infoIncomingItems.equals(_existingIncomingItems)) {
          return new RoomOpenHelper.ValidationResult(false, "incoming_items(com.awakencompany.data.models.IncomingItem).\n"
                  + " Expected:\n" + _infoIncomingItems + "\n"
                  + " Found:\n" + _existingIncomingItems);
        }
        final HashMap<String, TableInfo.Column> _columnsSoldItems = new HashMap<String, TableInfo.Column>(8);
        _columnsSoldItems.put("saleId", new TableInfo.Column("saleId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("itemCode", new TableInfo.Column("itemCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("itemName", new TableInfo.Column("itemName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("quantitySold", new TableInfo.Column("quantitySold", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("totalPrice", new TableInfo.Column("totalPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("saleDate", new TableInfo.Column("saleDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoldItems.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSoldItems = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSoldItems.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION",Arrays.asList("itemCode"), Arrays.asList("itemCode")));
        final HashSet<TableInfo.Index> _indicesSoldItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSoldItems = new TableInfo("sold_items", _columnsSoldItems, _foreignKeysSoldItems, _indicesSoldItems);
        final TableInfo _existingSoldItems = TableInfo.read(_db, "sold_items");
        if (! _infoSoldItems.equals(_existingSoldItems)) {
          return new RoomOpenHelper.ValidationResult(false, "sold_items(com.awakencompany.data.models.SoldItem).\n"
                  + " Expected:\n" + _infoSoldItems + "\n"
                  + " Found:\n" + _existingSoldItems);
        }
        final HashMap<String, TableInfo.Column> _columnsFinancialTransactions = new HashMap<String, TableInfo.Column>(6);
        _columnsFinancialTransactions.put("transactionId", new TableInfo.Column("transactionId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFinancialTransactions.put("transactionDate", new TableInfo.Column("transactionDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFinancialTransactions.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFinancialTransactions.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFinancialTransactions.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFinancialTransactions.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFinancialTransactions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFinancialTransactions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFinancialTransactions = new TableInfo("financial_transactions", _columnsFinancialTransactions, _foreignKeysFinancialTransactions, _indicesFinancialTransactions);
        final TableInfo _existingFinancialTransactions = TableInfo.read(_db, "financial_transactions");
        if (! _infoFinancialTransactions.equals(_existingFinancialTransactions)) {
          return new RoomOpenHelper.ValidationResult(false, "financial_transactions(com.awakencompany.data.models.FinancialTransaction).\n"
                  + " Expected:\n" + _infoFinancialTransactions + "\n"
                  + " Found:\n" + _existingFinancialTransactions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6492d3aa9de124553079ce3592562090", "dad2c593967ab57c2660b1d574ae2307");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "admins","users","products","orders","order_items","incoming_items","sold_items","financial_transactions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `admins`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `products`");
      _db.execSQL("DELETE FROM `orders`");
      _db.execSQL("DELETE FROM `order_items`");
      _db.execSQL("DELETE FROM `incoming_items`");
      _db.execSQL("DELETE FROM `sold_items`");
      _db.execSQL("DELETE FROM `financial_transactions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AdminDao.class, AdminDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderItemDao.class, OrderItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IncomingItemDao.class, IncomingItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SoldItemDao.class, SoldItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FinancialTransactionDao.class, FinancialTransactionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public AdminDao adminDao() {
    if (_adminDao != null) {
      return _adminDao;
    } else {
      synchronized(this) {
        if(_adminDao == null) {
          _adminDao = new AdminDao_Impl(this);
        }
        return _adminDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public OrderDao orderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public OrderItemDao orderItemDao() {
    if (_orderItemDao != null) {
      return _orderItemDao;
    } else {
      synchronized(this) {
        if(_orderItemDao == null) {
          _orderItemDao = new OrderItemDao_Impl(this);
        }
        return _orderItemDao;
      }
    }
  }

  @Override
  public IncomingItemDao incomingItemDao() {
    if (_incomingItemDao != null) {
      return _incomingItemDao;
    } else {
      synchronized(this) {
        if(_incomingItemDao == null) {
          _incomingItemDao = new IncomingItemDao_Impl(this);
        }
        return _incomingItemDao;
      }
    }
  }

  @Override
  public SoldItemDao soldItemDao() {
    if (_soldItemDao != null) {
      return _soldItemDao;
    } else {
      synchronized(this) {
        if(_soldItemDao == null) {
          _soldItemDao = new SoldItemDao_Impl(this);
        }
        return _soldItemDao;
      }
    }
  }

  @Override
  public FinancialTransactionDao financialTransactionDao() {
    if (_financialTransactionDao != null) {
      return _financialTransactionDao;
    } else {
      synchronized(this) {
        if(_financialTransactionDao == null) {
          _financialTransactionDao = new FinancialTransactionDao_Impl(this);
        }
        return _financialTransactionDao;
      }
    }
  }
}
