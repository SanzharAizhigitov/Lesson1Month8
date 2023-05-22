import org.gradle.api.JavaVersion

object AppConfig {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val TestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val jvmTarget =  "17"
    const val namespace =  "com.example.lesson1month8"
    const val applicationId =  "com.example.lesson1month8"
    val compatibility =  JavaVersion.VERSION_17
}