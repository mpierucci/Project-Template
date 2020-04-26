import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `module-plugin`
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {

    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
}