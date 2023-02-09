import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
    test {
        useJUnitPlatform()
    }
}
