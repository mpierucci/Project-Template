package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

import plugins.language.JavaCompatibilityPlugin
import plugins.language.KotlinPlugin
import plugins.qa.CoveragePlugin


class ModulePlugin : Plugin<Project> {

    private val plugin = KotlinPlugin()
        .appendNext(next = JavaCompatibilityPlugin())
        .appendNext(next = AndroidPlugin())
        .appendNext(next = TestPlugin())
        .appendNext(next = CoveragePlugin())

    override fun apply(project: Project) = plugin.apply(project)
}