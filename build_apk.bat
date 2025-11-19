@echo off
echo ========================================
echo Awaken Company - APK Builder
echo ========================================
echo.

REM Check if Android SDK is installed
if not exist "%ANDROID_HOME%" (
    echo [ERROR] Android SDK not found!
    echo.
    echo Please set ANDROID_HOME environment variable
    echo Example: set ANDROID_HOME=C:\Android\sdk
    echo.
    echo OR install Android Studio
    echo.
    pause
    exit /b 1
)

echo [INFO] Android SDK found at: %ANDROID_HOME%
echo.

REM Check if Java is installed
java -version >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Java not found!
    echo Please install JDK 17 or higher
    echo.
    pause
    exit /b 1
)

echo [INFO] Java found
echo.

REM Make gradlew executable (if on Unix-like system)
if exist gradlew (
    echo [INFO] Building APK...
    echo.
    call gradlew.bat assembleDebug
    if errorlevel 1 (
        echo.
        echo [ERROR] Build failed!
        pause
        exit /b 1
    )
    
    echo.
    echo ========================================
    echo [SUCCESS] APK built successfully!
    echo ========================================
    echo.
    echo APK Location: app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo You can now install this APK on your Android device!
    echo.
) else (
    echo [ERROR] gradlew not found!
    echo Please make sure you're in the android_app directory
    echo.
)

pause

