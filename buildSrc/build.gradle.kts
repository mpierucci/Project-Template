plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {

    plugins {
        val masterPlugin = "master-plugin"

        register(masterPlugin) {
            id = masterPlugin
            implementationClass = "MasterPlugin"
        }
    }
}

repositories {
    google()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:3.6.3")
    implementation(kotlin("gradle-plugin", "1.3.72"))

    implementation("org.jacoco:org.jacoco.core:0.8.5")
    implementation("com.pinterest:ktlint:0.36.0")

    testImplementation(gradleTestKit())
}

