plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.ded"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ded"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true // Adicionado do professor
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
        kotlinCompilerExtensionVersion = "1.5.1" // Adicionado do professor
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx) // Adicionado do professor
    implementation(libs.androidx.activity.compose) // Adicionado do professor
    implementation(platform(libs.androidx.compose.bom)) // Adicionado do professor
    implementation(libs.androidx.ui) // Adicionado do professor
    implementation(libs.androidx.ui.graphics) // Adicionado do professor
    implementation(libs.androidx.ui.tooling.preview) // Adicionado do professor
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose) // Adicionado do professor
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Adicionado do professor
    androidTestImplementation(libs.androidx.ui.test.junit4) // Adicionado do professor
    debugImplementation(libs.androidx.ui.tooling) // Adicionado do professor
    debugImplementation(libs.androidx.ui.test.manifest) // Adicionado do professor
  //  implementation("com.github.ViniciusAzambuja-Dev:Personagem-DungeonsAndDragons:v1.0")
}

