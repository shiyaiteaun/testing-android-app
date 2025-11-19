#!/bin/bash

echo "========================================"
echo "Awaken Company - APK Builder"
echo "========================================"
echo ""

# Check if Android SDK is installed
if [ -z "$ANDROID_HOME" ]; then
    echo "[ERROR] Android SDK not found!"
    echo ""
    echo "Please set ANDROID_HOME environment variable"
    echo "Example: export ANDROID_HOME=/path/to/android/sdk"
    echo ""
    echo "OR install Android Studio"
    echo ""
    exit 1
fi

echo "[INFO] Android SDK found at: $ANDROID_HOME"
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "[ERROR] Java not found!"
    echo "Please install JDK 17 or higher"
    echo ""
    exit 1
fi

echo "[INFO] Java found"
echo ""

# Make gradlew executable
if [ -f "gradlew" ]; then
    chmod +x gradlew
    echo "[INFO] Building APK..."
    echo ""
    ./gradlew assembleDebug
    
    if [ $? -eq 0 ]; then
        echo ""
        echo "========================================"
        echo "[SUCCESS] APK built successfully!"
        echo "========================================"
        echo ""
        echo "APK Location: app/build/outputs/apk/debug/app-debug.apk"
        echo ""
        echo "You can now install this APK on your Android device!"
        echo ""
    else
        echo ""
        echo "[ERROR] Build failed!"
        exit 1
    fi
else
    echo "[ERROR] gradlew not found!"
    echo "Please make sure you're in the android_app directory"
    echo ""
    exit 1
fi

