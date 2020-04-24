plugins {
    `module-plugin`
}

//TODO move this to uni test
project.afterEvaluate {


    val kotlinMainSourceSets =
        extensions.getByType(org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension::class).sourceSets.getByName(
            "main"
        ).kotlin

    check(kotlinMainSourceSets.srcDirs.size == 2) {
        """Expecting 2 sourcets
            * Main java
            * Main kotlin
            Found:${kotlinMainSourceSets.sourceDirectories.asPath}
        """.trimIndent()
    }

    val kotlinTestSourceSets =
        extensions.getByType(org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension::class).sourceSets.getByName(
            "test"
        ).kotlin

    check(kotlinTestSourceSets.srcDirs.size == 2) {
        """Expecting 2 sourcets
            * Test java
            * Test kotlin
            Found:${kotlinTestSourceSets.sourceDirectories.asPath}
        """.trimIndent()
    }

    check(plugins.hasPlugin(JacocoPlugin::class)) {
        "Jacoco Plugin should be applied"
    }

    val javExtension = extensions.getByType(JavaPluginExtension::class)

    check(javExtension.sourceCompatibility == JavaVersion.VERSION_1_8) {
        "Source compatibility should be set to ${JavaVersion.VERSION_1_8}"
    }

    check(javExtension.targetCompatibility == JavaVersion.VERSION_1_8) {
        "Source compatibility should be set to ${JavaVersion.VERSION_1_8}"
    }

    tasks.getByName("jacocoTestReport")
}

