import Plugins.Kotlin.kapt

plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
    id(Plugins.Kotlin.kapt);
}

java {
    sourceCompatibility = AppConfig.compatibility
    targetCompatibility = AppConfig.compatibility
}


dependencies{
    //Inject
    implementation(Deps.JavaX.inject)

    //Coroutines
    implementation(Deps.Coroutines.core)

    // Room
    implementation("androidx.room:room-common:2.5.1")
}