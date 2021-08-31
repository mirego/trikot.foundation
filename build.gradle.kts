buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
    }
}

repositories {
    google()
}

allprojects {
    repositories {
        google()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        maven("https://kotlin.bintray.com/kotlinx")
    }
}
