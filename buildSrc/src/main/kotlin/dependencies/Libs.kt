package dependencies

object Libs {

    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.2"

    const val okHttp = "com.squareup.okhttp3:okhttp:$4.5.0"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.2.0"
            const val fragment = "androidx.fragment:fragment-ktx:$1.2.4"
            const val activity = "androidx.activity:activity-ktx:1.1.0"
        }

        object LifeCycle {
            private const val lifeCycleVersion = "2.2.0"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
            const val test = "androidx.arch.core:core-testing:$lifeCycleVersion"
        }
    }

    object Dagger {
        private const val daggerVersion = "2.27"
        const val core = "com.google.dagger:dagger:$daggerVersion"
        const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Stetho {
        private const val stethoVersion = "1.5.1"
        const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
        const val stethoOk = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"
    }

    object Retrofit {
        private const val retrofitVersion = "2.8.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
        const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    }

    object Moshi {
        private const val moshiVersion = "1.9.2"
        const val core = "com.squareup.moshi:moshi:$moshiVersion"
        const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    }
}