plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "br.senai.sp.jandira.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.senai.sp.jandira.test"
        minSdk = 30
        targetSdk = 33
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")

    //material 3
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.material:material-icons-extended:1.5.0")

    //implementation ("androidx.compose.material3:material3:$material3_version")

    implementation("androidx.compose.material3:material3:1.1.0-alpha04")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0-alpha06")

    //Mais Icones
    implementation ("androidx.compose.material:material-icons-extended:1.2.0")

    //Implementacao do bottom navigation
    implementation ("androidx.compose.material:material:1.4.2")

    //Dependencias do navController
    implementation("androidx.navigation:navigation-compose:2.6.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.30.1")

    //Dependecias Retrofit
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")

    // implementação de data no textfield
    implementation("androidx.compose.material3:material3:1.2.0-alpha02")
    implementation("com.google.android.material:material:1.6.0-alpha01")

    //Dependência para a biblioteca do Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.0")

    //Dependência para componentes de IU do Jetpack Compose
    implementation("androidx.compose.foundation:foundation:1.1.0")
    implementation("androidx.compose.runtime:runtime:1.1.0")

    //Dependência para componentes de IU do Material Design no Jetpack Compose
    implementation("androidx.compose.material:material:1.1.0")

    //Dependência para componentes de IU do Jetpack Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.4.0")

    //Dependência para ViewModel no Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    //Dependência para Hilt (para injeção de dependência no Jetpack Compose)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")





    //Implementacao do bottom navigation
    implementation ("androidx.compose.material:material:1.4.2")

    //importe da dependencia do navControler
    implementation("androidx.navigation:navigation-compose:2.6.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.30.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")

    // implementação de data no textfiild
    implementation("androidx.compose.material3:material3:1.2.0-alpha02")
    implementation("com.google.android.material:material:1.6.0-alpha01")

    // teste
    // Dependência para a biblioteca do Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.0")

    // Dependência para componentes de IU do Jetpack Compose
    implementation("androidx.compose.foundation:foundation:1.1.0")
    implementation("androidx.compose.runtime:runtime:1.1.0")

    // Dependência para componentes de IU do Material Design no Jetpack Compose
    implementation("androidx.compose.material:material:1.1.0")

    // Dependência para componentes de IU do Jetpack Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.4.0")

    // Dependência para ViewModel no Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    // Dependência para Hilt (para injeção de dependência no Jetpack Compose)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

    implementation("androidx.compose.material3:material3:x.y.z")

    implementation ("androidx.compose.material:material:1.4.2")


    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation ("androidx.compose.runtime:runtime:1.1.0")
    implementation ("androidx.compose.ui:ui:1.1.0")
    implementation ("androidx.compose.material3:material3:1.1.0")

    implementation ("androidx.appcompat:appcompat:1.3.1") // Certifique-se de que você tenha a dependência do AppCompat

    //Lottie
    implementation("com.airbnb.android:lottie-compose:6.0.0")


    implementation("androidx.appcompat:appcompat:1.3.0")

    implementation ("androidx.compose.ui:ui:1.5.4")
    implementation ("androidx.compose.material:material:1.5.4")
    implementation ("androidx.activity:activity-compose:1.8.0")

    //implementation ("com.himanshoe:kalendar:1.3.2")
    implementation ("com.himanshoe:kalendar-endlos:1.3.2")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")


}