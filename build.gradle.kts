import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    java
    kotlin("jvm") version "1.6.10"
    id("org.openjfx.javafxplugin") version "0.0.12"
}

group = "dev.jacaro.school"
version = "1.0"

repositories {
    mavenCentral()
}

javafx {
    modules("javafx.controls", "javafx.fxml")
    version = "17.0.2"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Xms1g", "-Xmx48g")
}

application {
    mainModule.set("EightPuzzleSearch")
    mainClass.set("dev.jacaro.school.eightpuzzlesearch.entry.GUI")
}