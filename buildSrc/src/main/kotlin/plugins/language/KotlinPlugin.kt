package plugins.language

import com.android.build.gradle.BaseExtension
import dependencies.Libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import plugins.CompositePlugin
import plugins.PluginExtensions


/**
 * Applies kotlin dependencies for modules.
 *
 * Applies kotlin and kapt plugins (kotlin android for android module)
 * Sets main and test kotlin source files (androidTest for android modules)
 */
class KotlinPlugin : CompositePlugin {


    override fun apply(target: Project) {

        configureAndroidModule(target)

        target.plugins.apply(PLUGIN_KOTLIN_KAPT)

        target.dependencies { add(IMPLEMENTATION, Libs.stdlibJdk8) }
    }

    private fun configureAndroidModule(target: Project) {

        when (val androidExtension =
            target.extensions.findByName(PluginExtensions.EXTENSION_ANDROID)) {
            is BaseExtension -> {
                target.plugins.apply(PLUGIN_KOTLIN_ANDROID)
                androidExtension.sourceSets { SOURCE_SETS.forEach { named(it.key) { java.srcDir(it.value) } } }
            }
            else -> {
                configureKotlinModule(target)
            }
        }
    }

    private fun configureKotlinModule(target: Project) {

        target.plugins.apply(PLUGIN_KOTLIN)

        when (val kotlinExtension =
            target.extensions.findByName(PluginExtensions.EXTENSION_KOTLIN)) {
            is KotlinJvmProjectExtension -> {
                kotlinExtension.sourceSets.getByName("main")
                    .kotlin.srcDirs(
                        "src/main/kotlin",
                        "src/test/kotlin"
                    )
            }
            else -> {
                //no-op
            }
        }
    }

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN = "kotlin"
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