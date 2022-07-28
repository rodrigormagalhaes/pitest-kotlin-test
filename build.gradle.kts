import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"

    application

    id("info.solidsoft.pitest") version "1.7.4"

}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    useJUnitPlatform()
    //dependsOn("pitest")
}

//tasks.build {
//    dependsOn("pitest")
//}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
    junit5PluginVersion.set("0.15")
    avoidCallsTo.set(setOf("kotlin.jvm.internal"))
    mutators.set(setOf("STRONGER"))
//    mutators.set(setOf("TRUE_RETURNS"))
    targetClasses.set(setOf("ps.psp.digcom.pitestkotlintest.*"))
    threads.set(2)
    outputFormats.set(setOf("XML", "HTML"))
//    mutationThreshold.set(70)
}
