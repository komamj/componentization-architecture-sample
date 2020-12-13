plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

apply(from = "bintray.gradle")

gradlePlugin {
    plugins {
        create("commonConfigurationPlugin") {
            id = "com.github.komamj.common-configuration"
            displayName = "commonConfigurationPlugin"
            description = "The common configuration plugin for componentization architecture."
            implementationClass = "com.github.komamj.plugin.CommonConfiguration"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    implementation(Dependencies.Plugin.ANDROID)
    implementation(Dependencies.Plugin.KOTLIN)
    implementation("com.diffplug.spotless:spotless-plugin-gradle:4.1.0")
    implementation("org.jacoco:org.jacoco.core:0.8.5")
}
