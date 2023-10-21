plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("jacoco")
}

group = "me.likanug"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.processing:core:3.3.7")
    implementation("com.google.guava:guava:30.0-jre")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

sourceSets {
    main {
        kotlin.srcDirs("src/main/kotlin") // 设置 Kotlin 源代码目录
    }
}

application {
    // Define the main class for the application
    mainClass.set("com.likanug.dual.AppKt")
}

tasks.jar.configure {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest.attributes["Main-Class"] = "com.likanug.dual.AppKt"
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) })
}
