plugins {
    val kotlinVersion = "1.8.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.16.0"
}

group = "top.jie65535.mirai"
version = "1.2.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    val ktorVersion = "2.3.8"
    implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp-jvm:$ktorVersion")
}