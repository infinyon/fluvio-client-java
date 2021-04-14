plugins {
    id("application")
}

dependencies {
    implementation(project(":fluvio"))
}

application {
    mainClass.set("com.example.Simple")
}
repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
}
