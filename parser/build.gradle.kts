/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/8.0.2/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.assertj:assertj-core:3.25.3")
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:5.11.0")
    // https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
    testImplementation("org.mockito:mockito-junit-jupiter:5.11.0")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.hibernate:hibernate-core:5.6.5.Final")
    implementation("com.h2database:h2:2.2.224")
    implementation("javax.xml.bind:jaxb-api:2.3.1")

    // telegram bot
    // https://rubenlagus.github.io/TelegramBotsDocumentation/lesson-1.html#prepare-to-launch
    implementation("org.telegram:telegrambots:6.9.7.1")

    // json
    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
}

application {
    // Define the main class for the application.
    mainClass.set("parser.Main")
}

// compileJava.options.encoding = 'UTF-8'
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClass
    }
    // https://colabear754.tistory.com/198
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
