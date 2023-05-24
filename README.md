# DCS Test Automation Framework

## Table of Contents

* [Overview](#overview)
* [Installation](#installation)
* [Trigger Tests](#trigger-tests)
* [Test Report](#test-report)
* [Tech Stack](#tech-stack)
* [Test Coverage](#test-coverage)
* [Configuration](#Configuration)
* [APPS](#apps)
* [ReferenceExecution](#reference-execution)

### Overview
This is the basic test automation framework for Android and IOS app , which contains a set of automated test cases, which in turn composed of some proposed scenarios automated.

### Installation and Prerequisites
1. Clone this repo.
2. Install Node.
3. Run ``` npm install``` from root directory.
4. Install Appium
5. Install AndroidSDK and set path in bash profile
6. Execute the tests after providing configuration provide in the testng.xml file(refer below for details)
7. Have fun

### Running the tests
-> For Android Emulator
* Emulator should be up and running
* Emulator configs should match in testng.xml
  -> For iOS Simulator
* Simulator should be up and running
* Simulator configs should match in testng.xml

Test Execution can be configured in the Testng.xml

``` In Terminal or Commandline
./gradlew clean test
```

### Test Report
* Report Location - reports/index.html

### Tech Stack
* node
* AppiumServer
* Java
* Testng
* Gradle
* AndroidSDK
* Xcode for Simulator

### Test Coverage
* UserRegistrationTest - Android
    - Handling element which is not visible at first.
    - Handling popup's.
    - Error message validation.
* NetworkConnectionTest
    - Getting all the connected devices.
    - Getting devices connected on WiFi.
    - Getting WiFi Network Names of connected devices.
    - Getting UDIDs of devices which are not connected to WiFi.
    - Disabling the devices connected on WiFi
* AlertsAndPopupsTest - iOS
    - Launching the app
    - Handling Popups and buttons
    - Field and Message validations

### Configuration
* Make sure emulator and simulator device name and platform version in testng.xml parameters matches with yours
* Emulator and Simulator should be up and running
* NetworkConnectionTest - There should be more than two android devices/Emulators connected(one or more should be not on WiFi)

### APPS
* Apps used in the framework has been included in the Resource Folder.
* Android App - Telegram.apk
* IOS app - UIKitCatalog.app

### Reference Execution
* Gif files of execution has been placed in the reports folder for functional steps reference.
* Tests step by step description text file placed under resources -> TestsDescription folder.