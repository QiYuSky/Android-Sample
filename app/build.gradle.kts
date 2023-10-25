plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sample.android"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.sample.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
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
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(xLibs.bundles.basic)

    implementation(platform(xLibs.compose.bom))
    implementation(xLibs.bundles.compose.ui)
    implementation(xLibs.compose.material3)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.ext.androidtest)
    androidTestImplementation(libs.espresso.androidtest)

    androidTestImplementation(platform(xLibs.compose.bom))
    androidTestImplementation(xLibs.compose.ui.androidtest)
    debugImplementation(xLibs.compose.ui.tooling.debug)
    debugImplementation(xLibs.compose.ui.test.manifest.debug)
}