plugins {
    id("java")
    checkstyle
    id("io.freefair.lombok") version "8.4"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.apache.commons:commons-collections4:4.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }