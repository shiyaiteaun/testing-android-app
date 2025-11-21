# ⚡ Quick Push Guide

## 🚀 Push All Changes to GitHub (3 Steps)

### Step 1: Add All Changes
```powershell
git add .
```

### Step 2: Commit
```powershell
git commit -m "Fix layout errors, update dependencies, and fix GitHub Actions"
```

### Step 3: Push
```powershell
git push origin main
```

## 📋 Complete Command (Copy & Paste)

```powershell
git add .
git commit -m "Fix layout errors and update GitHub Actions workflow"
git push origin main
```

## ⚠️ Note
- Build files (`app/build/`) တွေက automatically ignore ဖြစ်သွားပါမယ် (`.gitignore` ထဲမှာ ရှိပြီးသား)
- Source code files နဲ့ documentation files တွေက push ဖြစ်သွားပါမယ်

## ✅ After Push
1. GitHub repository page ကို ဖွင့်ပါ
2. Files update ဖြစ်သွားတာ စစ်ဆေးပါ
3. **Actions** tab မှာ workflow run ကို စစ်ဆေးပါ
