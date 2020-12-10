buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.ANDROID_GRADLE_PLUGIN)
        classpath(Dependencies.Kotlin.GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}