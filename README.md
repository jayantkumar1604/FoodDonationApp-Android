# 📱 Food Waste Donation App (Android)

This is the **Android frontend application** for the Food Waste Donation system.  
The app allows users to submit food donation details and communicates with the Spring Boot backend using REST APIs.

---

## 🛠️ Tech Stack
- Android Studio
- Java
- Retrofit
- Gson
- XML (UI Design)

---

## 📂 Project Structure

app/src/main/java/com/foodwaste/app
 ├── MainActivity.java        # UI & user interaction
 ├── ApiService.java          # API definitions
 ├── RetrofitClient.java      # Retrofit setup
 └── model/FoodDonation.java  # Data model

---

## 🎯 Features
- Food donation form
- Retrofit-based REST API calls
- Success / failure messages
- Real device testing support

---

## 🌐 Permissions

In `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET"/>

<application
    android:usesCleartextTraffic="true">




🔌 Backend Connection (Retrofit)

Update RetrofitClient.java:

.baseUrl("http://<LAPTOP_IP>:8080/")

Example:
http://10.228.208.34:8080/


⚠️ Important:

Phone and laptop must be on the same Wi-Fi or mobile hotspot

Backend must be running on port 8080

📲 How to Run the App on a Real Android Phone
1️⃣ Enable Developer Mode on Phone

Open Settings

Go to About Phone

Tap Build Number 7 times

Developer Mode enabled

2️⃣ Enable USB Debugging

Settings → Developer Options

Turn ON USB Debugging

Allow USB debugging when prompted

3️⃣ Connect Phone to Laptop

Connect phone via USB cable

On laptop terminal, verify:

adb devices


Expected output:

<device_id>    device

4️⃣ Ensure Network Setup

Choose one:

✔ Phone Hotspot → connect laptop to hotspot

✔ Same Wi-Fi network

❌ Do NOT use different networks or VPN.

5️⃣ Run the App from Android Studio

Open project in Android Studio

Click Run ▶

Select real device

App installs and opens on phone

🧪 Testing the App

Open app on phone

Fill donation form

Click Donate Food

Toast message:

Donation Successful


Check backend / database for new entry
