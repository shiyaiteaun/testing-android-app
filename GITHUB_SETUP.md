# GitHub Actions သုံးပြီး APK Build လုပ်နည်း

## Step 1: GitHub Repository Create လုပ်ပါ

1. GitHub.com မှာ login လုပ်ပါ
2. New repository create လုပ်ပါ:
   - Repository name: `android_app` (သို့မဟုတ် နာမည်တစ်ခု)
   - Public သို့မဟုတ် Private ရွေးပါ
   - **README, .gitignore, license မထည့်ပါနဲ့** (ဘာလို့လဲဆိုတော့ code ကို push လုပ်မှာမို့)

## Step 2: Code ကို GitHub မှာ Push လုပ်ပါ

Terminal မှာ အောက်ပါ commands တွေ run လုပ်ပါ:

```powershell
# All files ကို add လုပ်ပါ
git add .

# Commit လုပ်ပါ
git commit -m "Initial commit - Android app"

# GitHub repository URL ကို add လုပ်ပါ (your-username နဲ့ your-repo-name ကို ပြောင်းပါ)
git remote add origin https://github.com/your-username/your-repo-name.git

# Code ကို push လုပ်ပါ
git branch -M main
git push -u origin main
```

## Step 3: GitHub Actions ကို Run လုပ်ပါ

1. GitHub repository page ကို သွားပါ
2. **Actions** tab ကို click လုပ်ပါ
3. Left sidebar မှာ **"Build Android APK"** workflow ကို click လုပ်ပါ
4. **"Run workflow"** button ကို click လုပ်ပါ
5. Branch ကို `main` (သို့မဟုတ် `master`) ရွေးပါ
6. **"Run workflow"** button ကို click လုပ်ပါ

## Step 4: APK Download လုပ်ပါ

1. Workflow run ပြီးရင် (အများအားဖြင့် 5-10 မိနစ်) **Actions** tab ကို သွားပါ
2. Latest workflow run ကို click လုပ်ပါ
3. **Artifacts** section မှာ **"app-debug"** ကို click လုပ်ပါ
4. APK file ကို download လုပ်ပါ

## အလိုအလျောက် Build

Code ကို push လုပ်တိုင်း အလိုအလျောက် build လုပ်ပါမယ်။ APK file ကို Artifacts ကနေ download လုပ်လို့ရပါတယ်။

## Manual Build

အလိုအလျောက် build မလုပ်ချင်ရင်:
1. **Actions** tab → **"Build Android APK"** workflow
2. **"Run workflow"** button → **"Run workflow"**

---

**Note:** GitHub Actions က free tier မှာ 2000 minutes/month ရပါတယ်။ Private repository မှာ 2000 minutes, Public repository မှာ unlimited ပါ။

