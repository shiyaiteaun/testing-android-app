# Awaken Company - Android Offline App

This is the Android offline version of the Awaken Company inventory management system.

## Features

### Admin Features:
- ✅ Admin Login
- ✅ Add New Items/Products
- ✅ Manage Incoming Items
- ✅ Track Sold Items
- ✅ View Remaining Stock
- ✅ Financial Statements & Analytics
- ✅ User Management

### User Features:
- ✅ User Login
- ✅ Browse Products
- ✅ Shopping Cart
- ✅ Place Orders
- ✅ View Order History

## Technology Stack

- **Language**: Kotlin
- **Database**: SQLite (offline)
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: Material Design Components
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/awakencompany/
│   │   │   ├── data/
│   │   │   │   ├── DatabaseHelper.kt
│   │   │   │   └── models/
│   │   │   ├── ui/
│   │   │   │   ├── admin/
│   │   │   │   ├── user/
│   │   │   │   └── auth/
│   │   │   └── utils/
│   │   └── res/
│   │       ├── layout/
│   │       ├── values/
│   │       └── drawable/
│   └── test/
└── build.gradle
```

## Setup Instructions

1. Open Android Studio
2. Import this project
3. Sync Gradle files
4. Run on device or emulator

## Database Schema

The app uses SQLite with the following tables:
- `admins` - Admin accounts
- `users` - User accounts
- `products` - Product inventory
- `orders` - Order records
- `order_items` - Order line items
- `incoming_items` - Incoming stock records
- `sold_items` - Sales records
- `financial_transactions` - Financial transactions

## Default Admin Credentials

- Username: `shiyai`
- Password: `Shiyai2025@`

## Notes

- All data is stored locally on the device
- No internet connection required
- Data can be exported/imported for backup

