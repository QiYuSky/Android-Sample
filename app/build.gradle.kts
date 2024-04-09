plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    alias(tLibs.plugins.hiltAndroid)
}

android {
    namespace = "com.sample.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sample.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
//    arguments {
//        arg("AROUTER_MODULE_NAME", project.getName())
//    }
}

dependencies {
    val composeBom = platform(xLibs.androidx.compose.bom)
    implementation(composeBom)
    implementation(xLibs.bundles.compose.basic)
    implementation(xLibs.bundles.compose.ui)

    implementation(tLibs.bundles.retrofit2)
    implementation(tLibs.hilt.android)
    kapt(tLibs.hilt.android.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(xLibs.bundles.androidTest.junit)

    androidTestImplementation(composeBom)
    androidTestImplementation(xLibs.bundles.androidTest.compose)
    debugImplementation(xLibs.bundles.debug.compose)
}