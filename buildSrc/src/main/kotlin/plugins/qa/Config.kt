package plugins.qa

import org.gradle.api.Project


internal fun Project.reportPath() = "$buildDir/reports"