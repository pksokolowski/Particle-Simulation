import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build315"
}

group = "com.github.pksokolowski"
version = "0.1.0"

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    val koinVersion = "3.1.2"
    val coroutinesVersion = "1.5.1"

    implementation(compose.desktop.currentOs)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("io.insert-koin:koin-core-jvm:3.1.2")

//    implementation("org.jetbrains.exposed", "exposed-core", "0.29.1")
//    implementation("org.jetbrains.exposed", "exposed-dao", "0.29.1")
//    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.29.1")
//    implementation("org.xerial", "sqlite-jdbc", "3.34.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ParticleSimulation"
            packageVersion = "1.0.0"
        }
    }
}