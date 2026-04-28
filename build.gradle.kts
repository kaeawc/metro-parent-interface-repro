plugins {
  kotlin("jvm") version "2.2.20"
  kotlin("kapt") version "2.2.20"
  id("dev.zacsweers.metro") version "1.0.0"
}

dependencies {
  implementation("dev.zacsweers.metro:runtime:1.0.0")
  implementation("com.google.dagger:dagger:2.56")
  kapt("com.google.dagger:dagger-compiler:2.56")
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}
