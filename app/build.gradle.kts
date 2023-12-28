plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.pr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pr"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*implementation (platform("org.dizitart:nitrite-bom:4.0.3")) // Reemplaza con la última versión estable
    implementation ("org.dizitart:nitrite")
    implementation ("org.dizitart:nitrite-mvstore-adapter")
    */

}

/*
buildscript {
    dependencies {
        //classpath("com.android.tools.build:gradle:7.0.0")
    }
}
*/