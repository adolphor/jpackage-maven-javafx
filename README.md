## Pre-requisites

Please checkout the prerequisites to run this application [here](https://github.com/gluonhq/gluonfx-maven-plugin#requirements).

### maven: must be 3.8.8
```
$ mvn -version
Apache Maven 3.8.8 (4c87b05d9aedce574290d1acc98575ed5eb6cd39)
Maven home: /Users/adolphor/Applications/maven/apache-maven-3.8.8
Java version: 17.0.3, vendor: GraalVM Community, runtime: /Library/Java/JavaVirtualMachines/graalvm-svm-java17-darwin-gluon-22.1.0.1-Final/Contents/Home
Default locale: zh_CN_#Hans, platform encoding: UTF-8
OS name: "mac os x", version: "12.7.1", arch: "x86_64", family: "mac"
```

### JAVA_HOME: GraalVM 22.1.0.1, OpenJDK 17.0.3
```
$ java -version
openjdk version "17.0.3" 2022-04-19
OpenJDK Runtime Environment GraalVM 22.1.0.1 (build 17.0.3+7-jvmci-22.1-b06)
OpenJDK 64-Bit Server VM GraalVM 22.1.0.1 (build 17.0.3+7-jvmci-22.1-b06, mixed mode, sharing)
```

## Instructions

> **Note**: The following are command line instructions. For IDE specific instructions please checkout [IDE section](https://docs.gluonhq.com/#_ide) of the Gluon documentation.

These application can run on the JVM on desktop platforms. To run the application, execute the following command:

```shell
mvn gluonfx:run
```

The same application can also run natively for on any targeted OS, including Android, iOS, Linux, Mac and Windows.

To create a native image, execute the following command:

```shell
# build
mvn clean gluonfx:build
# run
mvn gluonfx:nativerun
```

> **Note**: The above commands are target-platform dependent and might change depending on the platform.
For more details, please check
[GluonFX Maven Goals](https://github.com/gluonhq/gluonfx-maven-plugin#2-goals).

## native-image
```shell
# 编译
javac HelloWorld.java
# 转换
native-image HelloWorld
# 运行
./HelloWorld
```

## More information

Here are some helpful links:
* [Gluon-samples](https://github.com/gluonhq/gluon-samples)
* [Gluon documentation](https://docs.gluonhq.com/)
* [configuration documentation](https://docs.gluonhq.com/#_configuration)
* [Create native JavaFX applications using GraalVM 22 builds from Gluon](https://gluonhq.com/create-native-javafx-applications-using-graalvm-22-builds-from-gluon/)
* [GraalVM CE Gluon downloads](https://github.com/gluonhq/graal/releases)
* [GraalVM downloads](https://www.graalvm.org/downloads/)
* [GluonFX Maven Plugin](https://github.com/gluonhq/gluonfx-maven-plugin)
* [GluonFX Gradle Plugin](https://github.com/gluonhq/gluonfx-gradle-plugin)
