plugins {
    val kotlinVersion = "1.8.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.15.0"
}

group = "top.jie65535.mirai"
version = "1.0.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-client-core-jvm:2.3.2")
    implementation("io.ktor:ktor-client-okhttp-jvm:2.3.2")
}