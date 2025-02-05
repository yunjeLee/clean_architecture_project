import org.jetbrains.kotlin.gradle.idea.tcs.extras.projectArtifactsClasspathKey
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.hilt)
}

android {
    namespace = "com.android.cleanarchitectureproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.cleanarchitectureproject"
        minSdk = 24
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //common
    implementation(project(":common:common-model"))
    implementation(project(":common:common-coin-detail-model"))
    implementation(project(":common:common-util"))
    //data
    implementation(project(":data:data-coin"))
    implementation(project(":data:data-stock"))
    //di
    implementation(project(":di:di-coin"))
    implementation(project(":di:di-stock"))
    //domain
    implementation(project(":domain:domain-coin"))
    //feature
    implementation(project(":feature:feature-coin"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
//    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.compose.navigation)
}