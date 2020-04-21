package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import plugins.PluginExtensions.EXTENSION_ANDROID

internal class AndroidPlugin : CompositePlugin {

    override fun apply(target: Project) {
        val androidExtension = target.extensions.findByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        applyDefaultConfigurations(androidExtension)

    }

    private fun applyDefaultConfigurations(androidExtension: BaseExtension) {
        androidExtension.compileSdkVersion(SDK_COMPILE_VERSION)
        androidExtension.buildToolsVersion(BUILD_TOOLS_VERSION)

        androidExtension.defaultConfig {

            targetSdkVersion(SDK_TARGET_VERSION)
            minSdkVersion(SDK_MIN_VERSION)

            versionCode = VERSION_CODE
            versionName = VERSION_NAME

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    companion object {


        private const val SDK_COMPILE_VERSION = 29
        private const val BUILD_TOOLS_VERSION = "29.0.3"
        private const val SDK_TARGET_VERSION = SDK_COMPILE_VERSION
        private const val SDK_MIN_VERSION = 15

        private const val VERSION_CODE = 1
        private const val VERSION_NAME = "1.0.0"
    }
}