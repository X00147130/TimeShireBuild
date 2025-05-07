plugins{
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application) version "8.10.0"
    alias(libs.plugins.org.jetbrains.kotlin.android)
    /*
       alias(libs.plugins.jetbrains.kotlin.android) version "2.1.20"*/
    /*id("org.jetbrains.kotlin.plugin.compose") version "1.5.11"*/
}
android {
    namespace = "com.example.timeshiremastertrimmers"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.timeshiremastertrimmers"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
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
    buildFeatures {
        compose = true
    }
    composeOptions {

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("io.coil-kt.coil3:coil-compose:3.1.0")
    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation ("com.google.firebase:firebase-firestore-ktx:24.10.3")
    implementation ("com.google.firebase:firebase-auth-ktx:23.1.0")
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
    val nav_version ="2.8.9"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("com.android.tools.build:gradle:7.4.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}