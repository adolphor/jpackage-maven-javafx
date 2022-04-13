# Jpackage demo for JavaFX by Maven plugin

## Prerequisites
* OpenJDK 17 Installation (https://jdk.java.net/17/)
* On macOS [XCode](https://developer.apple.com/download/all/?q=for%20Xcode) is required.
* On Windows the free [WiX Toolset](https://wixtoolset.org) is required.

## System Environment
All operating system must be set environment variables below:
* JAVA_HOME

## Icons
The platform-specific icons can be found inside `hello-jpackage/jpackage/logo`.

## Usage

To do everything up until the actual installer generation (including generating the custom JVM):
```
mvn clean package
```

To generate an installer:
```
mvn clean install
```

To generate a specific installer:
```
mvn clean install -P build-mac -Dtype=apk
```

# Links
* [Oracle JDK 17 jpackage](https://docs.oracle.com/en/java/javase/17/jpackage/)
* [jpackage-maven-plugin](https://github.com/Akman/jpackage-maven-plugin)
* [maven-jpackage-template](https://github.com/wiverson/maven-jpackage-template)
* [JPackageScriptFX](https://github.com/dlemmermann/JPackageScriptFX)


