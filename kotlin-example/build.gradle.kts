apply<plugins.MasterPlugin>()

//TODO move this to uni test
project.afterEvaluate {


    val kotlinSourceSets =
        extensions.getByType(org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension::class).sourceSets.getByName(
            "main"
        ).kotlin

    check(kotlinSourceSets.srcDirs.size == 3) {
        """Expecting 3 sourcets
            * Main java
            * Test kotlin
            * Main kotlin
            Found:${kotlinSourceSets.sourceDirectories.asPath}
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

