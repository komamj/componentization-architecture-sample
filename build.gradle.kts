buildscript {
    val kotlin_version by extra("1.4.21")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.Plugin.ANDROID_GRADLE_PLUGIN)
        classpath(Dependencies.Plugin.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependencies.Plugin.AROUTER_PLUGIN)
        classpath(Dependencies.Plugin.HILT_GRADLE_PLUGIN)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
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

task<Exec>(name = "initGitHooks") {
    commandLine("sh", "-c", "git config core.hooksPath .githooks")
}

tasks.getByPath(":app:preBuild").dependsOn(":initGitHooks")