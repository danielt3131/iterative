plugins {
    id("java")
    id("application")
}

group = "io.github.danielt3131.cnt4504"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Define the main class for the application.
    mainClass.set("io.github.danielt3131.cnt4504.server.Main")
}

tasks.withType<Jar> {
    manifest {
        attributes["Manifest-Version"] = "1.0"
        attributes["Main-Class"] = "io.github.danielt3131.cnt4504.server.Main"
    }
    destinationDirectory = File("$rootDir")
}