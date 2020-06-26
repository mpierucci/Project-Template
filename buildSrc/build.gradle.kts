plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {

    plugins {
        val masterPlugin = "module-plugin"

        register(masterPlugin) {
            id = masterPlugin
            implementationClass = "plugins.ModulePlugin"
        }
    }
}

repositories {
    google()
    jcenter()
}

dependencies {

    implementation("com.android.tools.build:gradle:4.0.0")
    implementation(kotlin("gradle-plugin", "1.3.72"))

    implementation("org.jacoco:org.jacoco.core:0.8.5")

    testImplementation(gradleTestKit())
    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")
}

