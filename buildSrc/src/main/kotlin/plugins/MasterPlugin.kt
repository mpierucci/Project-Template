package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

import plugins.language.JavaPlugin
import plugins.language.KotlinPlugin
import plugins.qa.CoveragePlugin


class MasterPlugin : Plugin<Project> {

    private val plugin = KotlinPlugin()
        .appendNext(next = JavaPlugin())
        .appendNext(next = AndroidPlugin())
        .appendNext(next = CoveragePlugin())

    override fun apply(project: Project) = plugin.apply(project)
}