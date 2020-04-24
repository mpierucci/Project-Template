package plugins.language

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import plugins.PluginExtensions.EXTENSION_ANDROID
import plugins.PluginExtensions.EXTENSION_JAVA
import plugins.CompositePlugin


/**
 * Applies target and source compatibility to java 8
 *
 * works on android modules and java/kotlin modules
 */
internal class JavaPlugin : CompositePlugin{

    override fun apply(target: Project) {
        target.extensions
        //If it´s an android module we set compatibility through the a android extensions
        when (val androidExtension = target.extensions.findByName(EXTENSION_ANDROID)) {
            is BaseExtension -> {
                androidExtension.compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
            else -> {
                configureKotlinModule(target)
            }
        }
    }

    // applies to non android projects
    private fun configureKotlinModule(target: Project) {
        when (val javaExtension = target.extensions.findByName(EXTENSION_JAVA)) {
            is JavaPluginExtension -> {
                javaExtension.sourceCompatibility = JavaVersion.VERSION_1_8
                javaExtension.targetCompatibility = JavaVersion.VERSION_1_8
            }
            else -> {
                //no-op
            }
        }
    }
}