object Versions {
    const val AGP = "8.0.0"
    const val kotlin = "1.8.10"
    const val hilt = "2.44.2"
    const val room = "2.5.1"
    const val material = "1.5.0"
    const val appCompat = "1.6.1"
    const val espresso = "3.5.1"
    const val androidCore = "1.8.0"
    const val constraint = "2.1.4"
    const val extJUnit = "1.1.5"
    const val jUnit = "4.13.2"
    const val coroutines = "1.6.4"
    const val navGraph = "2.5.3"
    const val lifecycle = "2.6.1"
    const val fragment = "1.5.7"

}

object Deps {
    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler ="androidx.room:room-compiler:${Versions.room}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
    }
    object DaggerHilt{
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val core ="com.google.dagger:hilt-core:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }
    object Test{
        const val junit = "junit:junit:${Versions.jUnit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
    object Ui{
        const val core = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }
    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }
    object NavGraph {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navGraph}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navGraph}"
    }
    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }
    object JavaX{
        const val inject ="javax.inject:javax.inject:1"
    }
}

object Plugins {
    object Java{
        const val library = "java-library"
    }
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
        const val jvm = "org.jetbrains.kotlin.jvm"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }
}