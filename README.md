# Jpackage demo for JavaFX by Maven plugin

## Prerequisites
* OpenJDK 17 Installation (https://jdk.java.net/17/)
* On Windows you need to have the WIX toolset installed (https://wixtoolset.org)

## System Environment
All operating system must be set environment variables below:
* JAVA_HOME

## Icons
The platform-specific icons can be found inside `hello-jpackage/jpackage/logo`.

## Usage

* Build current system installer automatic
```
mvn clean install
```

* Build specified system installer
```
mvn clean install -P build-mac
```

# Links
* [Oracle JDK 17 jpackage](https://docs.oracle.com/en/java/javase/17/jpackage/)
* [jpackage-maven-plugin](https://github.com/Akman/jpackage-maven-plugin)
* [maven-jpackage-template](https://github.com/wiverson/maven-jpackage-template)
* [JPackageScriptFX](https://github.com/dlemmermann/JPackageScriptFX)


