buildscript {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("../repos")
        }
    }
    dependencies {
        classpath(Dependencies.Plugin.ANDROID)
        classpath(Dependencies.Plugin.KOTLIN)
        classpath(Dependencies.Plugin.AROUTER)
        classpath(Dependencies.Plugin.HILT)
        classpath("com.github.komamj:common-configuration:0.0.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("../repos")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

task<Exec>(name = "initGitHooks") {
    commandLine("sh", "-c", "git config core.hooksPath .githooks")
}

tasks.getByPath(":app:preBuild").dependsOn(":initGitHooks")