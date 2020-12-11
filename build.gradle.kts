buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.Plugin.ANDROID_GRADLE_PLUGIN)
        classpath(Dependencies.Plugin.KOTLIN_GRADLE_PLUGIN)
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