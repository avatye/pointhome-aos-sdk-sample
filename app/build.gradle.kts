plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.avatye.pointhome.pointhome.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.avatye.pointhome.pointhome.sample"
        minSdk = 19
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    //PointHome implementation
    implementation(libs.pointhome) // or ("com.avatye.pointhome:product:{SDK-VERSION}")
    //AppLovin
    implementation (libs.ad.plus.applovin) // or ("com.avatye.cashblock:ad-plus-applovin:$adCashVersion")
    //Cauly
    implementation (libs.ad.plus.cauly) // or ("com.avatye.cashblock:ad-plus-cauly:$adCashVersion")
    //Facebook Audience Network
    implementation (libs.ad.plus.fan) // or ("com.avatye.cashblock:ad-plus-fan:$adCashVersion")
    //MezzoMedia
    implementation (libs.ad.plus.mezzomedia) // or ("com.avatye.cashblock:ad-plus-mezzomedia:$adCashVersion")
    //Pangle
    implementation (libs.ad.plus.pangle) // or ("com.avatye.cashblock:ad-plus-pangle:$adCashVersion")
    //UnityAds
    implementation (libs.ad.plus.unity) // or ("com.avatye.cashblock:ad-plus-unity:$adCashVersion")
    //Vungle
    implementation (libs.ad.plus.vungle) // or ("com.avatye.cashblock:ad-plus-vungle:$adCashVersion")
    //Mobon
    implementation (libs.ad.plus.mobon) // or ("com.avatye.cashblock:ad-plus-mobon:$adCashVersion")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}