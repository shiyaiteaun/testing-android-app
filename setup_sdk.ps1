# Android SDK Setup Script (Without Android Studio)
# This script downloads and sets up Android SDK command line tools

Write-Host "========================================"
Write-Host "Android SDK Setup (Without Android Studio)"
Write-Host "========================================"
Write-Host ""

$SDK_DIR = "$env:LOCALAPPDATA\Android\Sdk"
$CMD_TOOLS_DIR = "$SDK_DIR\cmdline-tools"
$LATEST_DIR = "$CMD_TOOLS_DIR\latest"

# Create SDK directory if it doesn't exist
if (-not (Test-Path $SDK_DIR)) {
    Write-Host "[INFO] Creating SDK directory: $SDK_DIR"
    New-Item -ItemType Directory -Path $SDK_DIR -Force | Out-Null
}

# Check if command line tools already exist
if (Test-Path "$LATEST_DIR\bin\sdkmanager.bat") {
    Write-Host "[INFO] Android SDK Command Line Tools already installed"
    Write-Host "[INFO] Location: $LATEST_DIR"
} else {
    Write-Host "[INFO] Downloading Android SDK Command Line Tools..."
    Write-Host ""
    
    # Download URL for Windows command line tools
    $CMD_TOOLS_URL = "https://dl.google.com/android/repository/commandlinetools-win-11076708_latest.zip"
    $ZIP_FILE = "$env:TEMP\android-cmdline-tools.zip"
    
    try {
        Write-Host "[INFO] Downloading from: $CMD_TOOLS_URL"
        Write-Host "[INFO] This may take a few minutes..."
        Write-Host ""
        
        # Download using Invoke-WebRequest
        Invoke-WebRequest -Uri $CMD_TOOLS_URL -OutFile $ZIP_FILE -UseBasicParsing
        
        Write-Host "[INFO] Extracting command line tools..."
        
        # Create cmdline-tools directory
        if (-not (Test-Path $CMD_TOOLS_DIR)) {
            New-Item -ItemType Directory -Path $CMD_TOOLS_DIR -Force | Out-Null
        }
        
        # Extract to temp location first
        $TEMP_EXTRACT = "$env:TEMP\android-cmdline-tools-temp"
        Expand-Archive -Path $ZIP_FILE -DestinationPath $TEMP_EXTRACT -Force
        
        # Move to latest directory
        $EXTRACTED_DIR = Get-ChildItem -Path $TEMP_EXTRACT -Directory | Select-Object -First 1
        if ($EXTRACTED_DIR) {
            Move-Item -Path $EXTRACTED_DIR.FullName -Destination $LATEST_DIR -Force
        }
        
        # Cleanup
        Remove-Item -Path $ZIP_FILE -Force -ErrorAction SilentlyContinue
        Remove-Item -Path $TEMP_EXTRACT -Recurse -Force -ErrorAction SilentlyContinue
        
        Write-Host "[SUCCESS] Command line tools installed!"
    } catch {
        Write-Host "[ERROR] Failed to download command line tools: $_"
        Write-Host ""
        Write-Host "Please download manually from:"
        Write-Host "https://developer.android.com/tools/releases/cmdline-tools"
        Write-Host ""
        Write-Host "Extract to: $LATEST_DIR"
        exit 1
    }
}

# Set environment variables
Write-Host ""
Write-Host "[INFO] Setting up environment variables..."

# Add to PATH for current session
$env:ANDROID_HOME = $SDK_DIR
$env:ANDROID_SDK_ROOT = $SDK_DIR
$env:PATH = "$LATEST_DIR\bin;$env:PATH"

# Update local.properties
$LOCAL_PROPERTIES = "local.properties"
$SDK_PATH_ESCAPED = $SDK_DIR -replace '\\', '\\'
Write-Host "[INFO] Updating local.properties..."
Set-Content -Path $LOCAL_PROPERTIES -Value "sdk.dir=$SDK_PATH_ESCAPED"

Write-Host "[SUCCESS] Environment variables set!"
Write-Host ""
Write-Host "[INFO] Installing required SDK components..."
Write-Host "[INFO] This may take several minutes..."
Write-Host ""

# Accept licenses and install required SDK components
$SDKMANAGER = "$LATEST_DIR\bin\sdkmanager.bat"

# Accept all licenses
Write-Host "[INFO] Accepting licenses..."
& $SDKMANAGER --licenses | ForEach-Object {
    if ($_ -match "\(y/N\)") {
        "y"
    } else {
        $_
    }
} | & $SDKMANAGER --licenses

# Install required SDK components
Write-Host ""
Write-Host "[INFO] Installing SDK Platform 34, Build Tools, and Platform Tools..."
& $SDKMANAGER "platform-tools" "platforms;android-34" "build-tools;34.0.0" --channel=0

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "========================================"
    Write-Host "[SUCCESS] Android SDK setup complete!"
    Write-Host "========================================"
    Write-Host ""
    Write-Host "SDK Location: $SDK_DIR"
    Write-Host ""
    Write-Host "To make this permanent, add to your environment variables:"
    Write-Host "ANDROID_HOME=$SDK_DIR"
    Write-Host "ANDROID_SDK_ROOT=$SDK_DIR"
    Write-Host ""
    Write-Host "You can now build the APK using:"
    Write-Host "  .\gradlew.bat assembleDebug"
    Write-Host ""
} else {
    Write-Host ""
    Write-Host "[ERROR] Failed to install SDK components"
    Write-Host "You may need to run this script as Administrator"
    exit 1
}

