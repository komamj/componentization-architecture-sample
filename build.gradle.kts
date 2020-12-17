buildscript {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("../repos")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.alibaba:arouter-register:1.0.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28.3-alpha")
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