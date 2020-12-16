buildscript {
    val kotlin_version by extra("1.4.21")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.Plugin.ANDROID)
        classpath(Dependencies.Plugin.KOTLIN)
        classpath(Dependencies.Plugin.AROUTER)
        classpath(Dependencies.Plugin.HILT)
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