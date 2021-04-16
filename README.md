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
[documentation](https://infinyon.github.io/fluvio-client-java/javadoc/com/infinyon/fluvio/package-summary.html).

Note: topic creation and deletion is not yet supported in this client.

# Example Usage

Checkout our [example
project](https://github.com/infinyon/fluvio-client-java/tree/main/examples) and
our
[`Simple.java`](https://github.com/infinyon/fluvio-client-java/blob/main/examples/src/main/java/com/fluvio/example/Simple.java).

# Developer Notes

Ensure that `JAVA_ROOT` points to the base directory for the java installation.
It's under `/usr/lib/jvm/java-15-openjdk` for archlinux depending on the
version of java.
