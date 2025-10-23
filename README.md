# MiBlisterApp (clean start)

This repository has been reset to a minimal Android Kotlin + Compose skeleton with Room and common dependencies configured.

How to build:

1. Ensure Java 11 is installed.
2. Run the Gradle wrapper to build: `./gradlew clean assembleDebug` (Linux/mac) or `./gradlew.bat clean assembleDebug` (Windows).
3. If you see Kotlin metadata errors or kapt issues, run `./gradlew --stop` and then remove `app/build/tmp/kapt3` and rebuild.

Notes:
- This is a minimal starting point. I'll follow up by adding navigation, screens and ViewModels on your confirmation.
