<h1 align="center">Fluvio Client for Java</h1>
<div align="center">
 <strong>
   Java binding for Fluvio streaming platform.
 </strong>
</div>
<br />

[![CI](https://github.com/infinyon/fluvio-client-java/actions/workflows/ci.yml/badge.svg)](https://github.com/infinyon/fluvio-client-java/actions/workflows/ci.yml)
[![Fluvio Cloud CI](https://github.com/infinyon/fluvio-client-java/actions/workflows/cloud.yml/badge.svg)](https://github.com/infinyon/fluvio-client-java/actions/workflows/cloud.yml)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/infinyon/fluvio-client-java/blob/master/LICENSE-APACHE)
[![JavaDoc](https://img.shields.io/badge/docs-javadoc-blue)](https://infinyon.github.io/fluvio-client-java/)

## Documentation
Fluvio client uses javadoc to generate the client API
[documentation](https://infinyon.github.io/fluvio-client-java/).

Note: topic creation and deletion is not yet supported in this client.

# Example Usage

Checkout our [example
project](https://github.com/infinyon/fluvio-client-java/tree/main/examples) and
our
[`Simple.java`](https://github.com/infinyon/fluvio-client-java/blob/main/examples/src/main/java/com/fluvio/example/Simple.java).

Make sure your `build.gradle` has the `maven` section below
```groovy
repositories {
    jcenter()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/infinyon/fluvio-client-java")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")

        }
    }
}
```
and add `com.infinyon:fluvio-16:0.0.0` as a dependency. The section should look
something like:
```groovy
dependencies {
    // Use JUnit test framework.
    testImplementation 'junit:junit:4.13'

    // This dependency is used by the application.
    implementation 'com.google.guava:guava:29.0-jre'

    implementation 'com.infinyon:fluvio-16:0.0.1'
}
```

The `artfiactId` is dependent on the version of java. See [our
packages](https://github.com/orgs/infinyon/packages?repo_name=fluvio-client-java)
to see the published versions. If there's a version you'd like to be published
please [open an issue](https://github.com/infinyon/fluvio-client-java/issues).

# Developer Notes

* Ensure that `JAVA_ROOT` points to the base directory for the java installation.
It's under `/usr/lib/jvm/java-15-openjdk` for archlinux depending on the
version of java.

* CI will run `make test` will test that the rust is linked correctly but does
not test the connection to a fluvio cluster. To verify that things work, run
`make examples`.

* To publish, update the `version` in
[`fluvio/build.gradle`](https://github.com/infinyon/fluvio-client-java/blob/main/fluvio/build.gradle)
to your liking and run the [Publish
CI](https://github.com/infinyon/fluvio-client-java/actions/workflows/publish.yml).

* The [documentation on github
pages](https://infinyon.github.io/fluvio-client-java/) is updated on every
merge into `main`.
