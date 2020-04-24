package plugins.language

import com.android.build.gradle.BaseExtension
import dependencies.Libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import plugins.CompositePlugin


/**
 * Applies kotlin dependencies for modules.
 *
 * Applies kotlin and kapt plugins (kotlin android for android module)
 * Sets main and test kotlin source files (androidTest for android modules)
 */
class KotlinPlugin : CompositePlugin {


    override fun apply(target: Project) {

        target.extensions.findByType(BaseExtension::class.java)?.let { androidExtension ->

            target.plugins.apply(PLUGIN_KOTLIN_ANDROID)
            target.plugins.apply(PLUGIN_KOTLIN_KAPT)

            androidExtension.sourceSets { SOURCE_SETS.forEach { named(it.key) { java.srcDir(it.value) } } }

            return@apply
        }

        configureKotlinModule(target)

        target.dependencies { add(IMPLEMENTATION, Libs.stdlibJdk8) }
    }

    private fun configureKotlinModule(target: Project) {

        target.plugins.apply(PLUGIN_KOTLIN_JVM)

        target.extensions.findByType(KotlinJvmProjectExtension::class.java)
            ?.let { kotlinExtension ->
                kotlinExtension.sourceSets.getByName("main").kotlin.srcDirs(SOURCE_SETS["main"])
                kotlinExtension.sourceSets.getByName("test").kotlin.srcDirs(SOURCE_SETS["test"])
            }

        target.plugins.apply(PLUGIN_KOTLIN_KAPT)
    }

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"

        private const val IMPLEMENTATION = "implementation"

        private const val EXTENSION_ANDROID = "android"
        private val SOURCE_SETS = mapOf(
            "main" to "src/main/kotlin/",
            "test" to "src/test/kotlin/",
            "androidTest" to "src/androidTest/kotlin/"
        )
    }
}