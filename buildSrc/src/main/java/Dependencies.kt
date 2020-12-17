object Dependencies {
    object Plugin {
        const val ANDROID =
            "com.android.tools.build:gradle:${Versions.Plugin.ANDROID_GRADLE_PLUGIN}"
        const val KOTLIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugin.KOTLIN}"
        const val HILT =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.Plugin.HILT}"
        const val AROUTER = "com.alibaba:arouter-register:${Versions.Plugin.ROUTER}"
        const val BINTRAY =
            "com.jfrog.bintray.gradle:gradle-bintray-plugin:${Versions.Plugin.BINTRAY}"
    }

    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.KOTLIN}"
        const val COROUTINES_CORE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.COROUTINES}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.COROUTINES}"
        const val COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.COROUTINES}"
    }

    object AndroidX {
        const val BIOMETRIC = "androidx.biometric:biometric:${Versions.AndroidX.BIOMETRIC}"
        const val ANNOTATION = "androidx.annotation:annotation:${Versions.AndroidX.ANNOTATION}"
        const val MULTIDEX = "androidx.multidex:multidex:${Versions.AndroidX.MULTIDEX}"
        const val LIFECYCLE =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_COMMON_JAVA8 =
            "androidx.lifecycle:lifecycle-common-java8:${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_LIVE_DATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL_STATE =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate::${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_SERVICE =
            "androidx.lifecycle:lifecycle-service:${Versions.AndroidX.LIFECYCLE}"
        const val LIFECYCLE_PROCESS =
            "androidx.lifecycle:lifecycle-process:${Versions.AndroidX.LIFECYCLE}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.AndroidX.MATERIAL}"
        const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:${Versions.AndroidX.VIEWPAGER2}"
        const val WEBKIT = "androidx.webkit:webkit:${Versions.AndroidX.WEBKIT}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.AndroidX.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.AndroidX.ROOM}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.AndroidX.ROOM}"
        const val HILT_VIEWMODEL =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.AndroidX.HILT}"
        const val NAVIGATION_FRAGMENT_KTX =
            "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_UI_KTX =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
        const val WORK = "androidx.work:work-runtime-ktx:${Versions.AndroidX.WORK}"
        const val STARTUP = "androidx.startup:startup-runtime:${Versions.AndroidX.STARTUP}"
        const val PAGING_RUNTIME = "androidx.paging:paging-runtime:${Versions.AndroidX.PAGING}"
        const val DATASTORE_PREFERENCES =
            "androidx.datastore:datastore-preferences:${Versions.AndroidX.DATASTORE}"
    }

    object Others {
        const val PERMISSION = "pub.devrel:easypermissions:${Versions.Others.PERMISSION}"
        const val ROUTER = "com.alibaba:arouter-api:${Versions.Others.ROUTER}"
        const val ROUTER_COMPILER =
            "com.alibaba:arouter-compiler:${Versions.Others.ROUTER_COMPILER}"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.Others.TIMBER}"
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Others.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.Others.GLIDE}"
        const val GLIDE_OKHTTP_INTEGRATION =
            "com.github.bumptech.glide:okhttp3-integration:${Versions.Others.GLIDE}"
        const val GSON = "com.google.code.gson:gson:${Versions.Others.GSON}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Others.RETROFIT}"
        const val CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:${Versions.Others.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.Others.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Others.OKHTTP_LOGGING_INTERCEPTOR}"
        const val OKIO = "com.squareup.okio:okio:${Versions.Others.OKIO}"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Others.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Others.HILT}"
        const val LOTTIE = "com.airbnb.android:lottie:${Versions.Others.LOTTIE}"
    }

    object JunitTest {
        const val JUNIT = "junit:junit:${Versions.JunitTest.JUNIT}"
        const val TRUTH = "com.google.truth:truth:${Versions.JunitTest.TRUTH}"
        const val MOCK_CORE = "org.mockito:mockito-core:${Versions.JunitTest.MOCKITO_CORE}"
        const val LIFECYCLE = "androidx.arch.core:core-testing:${Versions.JunitTest.LIFECYCLE}"
    }

    object AndroidTest {
        const val JUNIT = "androidx.test.ext:junit:${Versions.AndroidTest.JUNIT}"
        const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${Versions.AndroidTest.ESPRESSO_CORE}"
        const val NAVIGATION =
            "androidx.navigation:navigation-testing:${Versions.AndroidTest.NAVIGATION}"
    }
}