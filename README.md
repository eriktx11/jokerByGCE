[![API](https://img.shields.io/badge/API-15%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=15)
# Gradle for Android and Java

## Requirements

Must have a Google Cloud Endpoints account.

## About

Forked out of [udacity/ud867](https://github.com/udacity/ud867/tree/master/FinalProject)

This project consist of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## This application was modified to satisfy nano degree project, following the steps below:

### Step 0: Starting Point

Built the starter code to an emulator.

### Step 1: Create a Java library

Created a Java library that provides jokes. Created a new
Gradle Java project. Then
introduced a project dependency between app and the new Java Library.

Made the button display a toast showing a joke retrieved from Java joke
telling library.

### Step 2: Create an Android Library

Created an Android Library containing an Activity that displays a joke
passed to it as an intent extra. Wired up project dependencies so that the
button can now pass the joke from the Java Library to the Android Library.

### Step 3: Create GCE Module

Set up a Google Cloud Endpoints development server,
and pulls jokes from there. 

Introduced project dependency between Java library and GCE module,
and modified the GCE starter code to pull jokes from Java library. Created
an Async task to retrieve jokes. Made the button kick off a task to retrieve a
joke, then launch the activity from your Android Library to display it.

### Step 4: Add Functional Tests

Added code to test that Async task successfully retrieves a non-empty
string. 

### Step 5: Add a Paid Flavor

Added free and paid product flavors to app. Removed the ad (and any
dependencies) from the paid flavor.

## License

[Apache 2.0](https://svn.apache.org/viewvc/httpd/httpd/trunk/LICENSE?view=markup).  
