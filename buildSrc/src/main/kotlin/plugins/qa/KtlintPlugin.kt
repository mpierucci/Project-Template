package plugins.qa

import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.get
import plugins.CompositePlugin


/**
 * Plugin to register ktlint taks
 *
 * ktlint: applied to all kotlin file under src  files
 *
 *
 * ktlintFormat:
 *
 *
 * enables some sort of incremental configuration thanks to
 * https://medium.com/@vanniktech/making-your-gradle-tasks-incremental-7f26e4ef09c3
 */

//TODO not working

internal class KtlintPlugin : CompositePlugin {

    override fun apply(target: Project) {

        val reportPath = "${target.reportPath()}/ktlint"

        val inputFiles = target.fileTree(
            mapOf(
                "dir" to "src",
                "include" to SOURCE_FILES
            )
        )

        target.configurations.create("ktlint")

        target.tasks.register("ktlint", JavaExec::class.java) {
            dependsOn(project.tasks["check"])
            inputs.files(inputFiles)
            outputs.files("${reportPath}/ktlint-checkstyle-report.xml")

            group = "verification"
            description = "Check Kotlin code style."
            main = "com.pinterest.ktlint.Main"
            args = mutableListOf(
                "--reporter=plain",
                "--reporter=checkstyle,output=${reportPath}",
                SOURCE_FILES
            )
            classpath = project.configurations.getByName("ktlint")
        }

        target.tasks.register("ktlintFormat", JavaExec::class.java) {
            group = "formatting"
            description = "Fix Kotlin code style deviations."
            classpath = project.configurations.getByName("ktlint")
            main = "com.github.shyiko.ktlint.Main"
            args("--android", "-F", SOURCE_FILES)
        }
    }

    companion object {
        private const val SOURCE_FILES = "src/**/*.kt"
    }

}