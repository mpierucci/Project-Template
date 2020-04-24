package dependencies

object Test {

    const val jUnit = "junit:junit:4.13"

    const val testRunner = "androidx.test:runner:1.2.0"

    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"

    const val lifeCycle = "androidx.arch.core:core-testing:2.1.0"

    val truth = "com.google.truth:truth:1.0.1"

    object Esspresso {
        const val core = "androidx.test.espresso:espresso-core:3.2.0"
        const val jUnit = "androidx.test.ext:junit:1.0.0"
        const val idlingResources = "androidx.test.espresso:espresso-core:3.2.0"
        const val contrib = "com.android.support.test.espresso:espresso-contrib:2.0"
    }
}