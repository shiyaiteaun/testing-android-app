# 📥 JDK Install Guide (Myanmar)

## 🔍 Problem
သင့်စက်မှာ **JRE (Java Runtime Environment)** ပဲ install လုပ်ထားပါတယ်။ 
Android app build လုပ်ဖို့ **JDK (Java Development Kit)** လိုအပ်ပါတယ်။

## ✅ Solution: JDK Install လုပ်ပါ

### Option 1: Adoptium (OpenJDK) - Recommended (အလွယ်ဆုံး)

1. **Download Link သွားပါ:**
   - https://adoptium.net/temurin/releases/?version=8
   - **Version:** 8 (LTS)
   - **Operating System:** Windows
   - **Architecture:** x64
   - **Package Type:** JDK

2. **Download လုပ်ပါ** (.msi file)

3. **Install လုပ်ပါ:**
   - Download လုပ်ထားတဲ့ .msi file ကို double-click လုပ်ပါ
   - "Next" ကို နှိပ်ပြီး install လုပ်ပါ
   - Default location: `C:\Program Files\Eclipse Adoptium\jdk-8.0.xxx-hotspot\`

4. **JDK Path ကို မှတ်ထားပါ:**
   - Install လုပ်ပြီးရင် JDK path ကို မှတ်ထားပါ
   - Example: `C:\Program Files\Eclipse Adoptium\jdk-8.0.392-8-hotspot`

### Option 2: Oracle JDK (Official)

1. **Download Link:**
   - https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html
   - Oracle account လိုအပ်ပါတယ် (free signup)

2. **Download:**
   - Windows x64: `jdk-8u471-windows-x64.exe`

3. **Install:**
   - Default location: `C:\Program Files\Java\jdk1.8.0_471\`

## 🔧 JDK Path ကို Set လုပ်ပါ

### Method 1: gradle.properties မှာ Set လုပ်ပါ (အလွယ်ဆုံး)

1. `android_app/gradle.properties` file ကို ဖွင့်ပါ

2. အောက်က line ကို ထည့်ပါ (သင့် JDK path နဲ့ ပြောင်းပါ):

```properties
org.gradle.java.home=C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.392-8-hotspot
```

**သတိပြုရန်:**
- Backslash (`\`) ကို double backslash (`\\`) လုပ်ရပါမယ်
- Path မှာ space ရှိရင် quotes မထည့်ရပါဘူး

**Example paths:**
```
org.gradle.java.home=C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.392-8-hotspot
org.gradle.java.home=C:\\Program Files\\Java\\jdk1.8.0_471
```

### Method 2: Environment Variable (System-wide)

1. **Windows Key + R** နှိပ်ပါ
2. `sysdm.cpl` ရိုက်ပြီး Enter နှိပ်ပါ
3. **Advanced** tab → **Environment Variables** ကို နှိပ်ပါ
4. **System variables** အောက်မှာ **New** ကို နှိပ်ပါ
5. **Variable name:** `JAVA_HOME`
6. **Variable value:** JDK path (Example: `C:\Program Files\Eclipse Adoptium\jdk-8.0.392-8-hotspot`)
7. **OK** ကို နှိပ်ပါ
8. **PowerShell/Terminal ကို restart** လုပ်ပါ

## ✅ Verify JDK Installation

PowerShell မှာ:

```powershell
# JDK path check
$env:JAVA_HOME

# javac check (JDK မှာပဲ ရှိတယ်)
javac -version

# java version
java -version
```

**Expected output:**
```
javac 1.8.0_xxx
java version "1.8.0_xxx"
```

## 🚀 Build Again

JDK install လုပ်ပြီးရင်:

```powershell
cd android_app
.\gradlew.bat clean
.\gradlew.bat assembleDebug
```

## ❓ FAQ

**Q: JRE နဲ့ JDK က ဘာကွာလဲ?**
- **JRE:** Java programs run လုပ်ဖို့ (java command)
- **JDK:** Java programs compile/build လုပ်ဖို့ (javac command)
- Android build လုပ်ဖို့ JDK လိုအပ်ပါတယ်

**Q: JDK install လုပ်ပြီးရင် JRE ကို uninstall လုပ်ရမလား?**
- မလုပ်ရပါဘူး။ JDK ထဲမှာ JRE ပါပြီးသား ဖြစ်ပါတယ်။

**Q: Multiple JDK versions install လုပ်လို့ရလား?**
- ရပါတယ်။ gradle.properties မှာ သုံးချင်တဲ့ version path ကို set လုပ်ပါ။

## 📝 Quick Steps Summary

1. ✅ Adoptium JDK 8 download လုပ်ပါ
2. ✅ Install လုပ်ပါ
3. ✅ `gradle.properties` မှာ `org.gradle.java.home` set လုပ်ပါ
4. ✅ `.\gradlew.bat assembleDebug` run လုပ်ပါ
