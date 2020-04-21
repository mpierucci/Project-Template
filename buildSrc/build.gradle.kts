plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
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
}

