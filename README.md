# Jpackage demo for JavaFX by Maven plugin

## Prerequisites
* OpenJDK 21 Installation
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
mvn clean javafx:run

mvn clean javafx:jlink
jpackage --type app-image \
         --name JavaFxHelloApp \
         --module com.example.javafx/com.example.javafx.HelloApplication \
         --runtime-image ./target/runtime-image \
         --dest ./target/
```

## Convert Non-Modular Jar to Modular

eg:
```shell
cd convert
./gen.sh in/commons-lang3-3.5.jar
./build.sh in/commons-lang3-3.5.jar commons.lang
jdeps --list-deps out/commons.lang.jar
```

# 编译打包探索

## maven组件打包

### maven：javafx-maven-plugin
```shell
# 运行
mvn clean javafx:run
# 裁切
mvn clean javafx:jlink
```

```xml
<plugins>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
      <source>21</source>
      <target>21</target>
      <release>21</release>
    </configuration>
  </plugin>
  <plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>
    <executions>
      <execution>
        <!-- Default configuration for running with: mvn clean javafx:run -->
        <id>default-cli</id>
        <configuration>
          <mainClass>${main-module}/${main-class}</mainClass>
          <launcher>${launcher}</launcher>
          <jlinkImageName>${runtime-image}</jlinkImageName>
          <noManPages>true</noManPages>
          <stripDebug>true</stripDebug>
          <noHeaderFiles>true</noHeaderFiles>
        </configuration>
      </execution>
    </executions>
  </plugin>
</plugins>
```

## 手动命令打包
maven配置如下：

```xml
<plugins>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
      <source>21</source>
      <target>21</target>
      <release>21</release>
    </configuration>
  </plugin>
  <!-- 主程序Jar入口 -->
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
      <outputDirectory>${project.build.directory}/libs/launch</outputDirectory>
      <archive>
        <manifest>
          <mainClass>${main-class}</mainClass>
          <addClasspath>true</addClasspath>
        </manifest>
      </archive>
    </configuration>
  </plugin>
  <!-- 依赖Jar仓库 -->
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
      <execution>
        <id>copy-dependencies</id>
        <phase>prepare-package</phase>
        <goals>
          <goal>copy-dependencies</goal>
        </goals>
        <configuration>
          <outputDirectory>${project.build.directory}/libs/javafx</outputDirectory>
          <overWriteReleases>false</overWriteReleases>
          <overWriteSnapshots>true</overWriteSnapshots>
          <overWriteIfNewer>true</overWriteIfNewer>
          <includeScope>compile</includeScope>
          <includeScope>runtime</includeScope>
        </configuration>
      </execution>
    </executions>
  </plugin>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-install-plugin</artifactId>
    <version>3.0.0-M1</version>
    <configuration>
      <!-- javafx 项目不需要install到maven仓库，所以跳过install -->
      <skip>true</skip>
    </configuration>
  </plugin>
</plugins>
```

### command：runtime image 包含所有内容
类似javafx-maven-plugin的效果，只需要手动jlink的时候，add-modules所有依赖即可。
```shell
# 编译
mvn clean package
# 本机JDK试运行
java --module-path ./target/libs/launch:./target/libs/javafx --add-modules com.example.javafx -jar ./target/libs/launch/JavaFxHelloApp.jar
# 裁切jdk
jlink --module-path ./target/libs/launch:./target/libs/javafx --add-modules com.example.javafx --output ./target/runtime-image --no-header-files --no-man-pages
# 裁切JDK试运行
./target/runtime-image/bin/java -jar ./target/libs/launch/JavaFxHelloApp.jar
# 裁切打包成功
jpackage --type app-image \
         --name JavaFxHelloApp \
         -m com.example.javafx/com.example.javafx.HelloApplication \
         --runtime-image ./target/runtime-image \
         --dest ./target/
```

### command：runtime image 不包含主程序
jlink只裁切jdk、javafx、其他maven包，但不包含项目自身jar包。特点：可以直接替换主程序jar包，方便升级。
```shell
# 编译
mvn clean package
# 本机JDK试运行
java --module-path ./target/libs/javafx --add-modules javafx.controls,javafx.fxml -jar ./target/libs/JavaFxHelloApp.jar
# 裁切jdk
jlink --module-path ./target/libs/javafx --add-modules javafx.controls,javafx.fxml --output ./target/runtime-image --no-header-files --no-man-pages
# 裁切JDK试运行
./target/runtime-image/bin/java -jar ./target/libs/launch/JavaFxHelloApp.jar
# 裁切打包成功
jpackage --type app-image \
         --name JavaFxHelloApp \
         --runtime-image ./target/runtime-image \
         --input ./target/libs/launch \
         --main-jar JavaFxHelloApp.jar \
         --main-class com.example.javafx.HelloApplication \
         --dest ./target/
```

## jpackage 镜像
TODO：建议，这样就完全自动化了。
```xml
<plugin>
  <artifactId>maven-antrun-plugin</artifactId>
  <version>3.0.0</version>
  <executions>
    <execution>
      <configuration>
        <target>
          <exec executable="jpackage">
            <!-- macOS 可选参数：dmg 或者 app-image -->
            <arg value="--type"/>
            <arg value="dmg"/>
            <arg value="--name"/>
            <arg value="${app-name}"/>
            <arg value="-m"/>
            <arg value="${main-module}/${main-class}"/>
            <arg value="--runtime-image"/>
            <arg value="${project.build.directory}/runtime-image"/>
            <arg value="--icon"/>
            <arg value="${project.basedir}/jpackage/logo/macosx/duke.icns"/>
            <arg value="--dest"/>
            <arg value="${project.build.directory}"/>
            <!-- 可以添加更多 jpackage 参数 -->
          </exec>
        </target>
      </configuration>
      <goals>
        <goal>run</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```


# Links
* [The jpackage Command](https://docs.oracle.com/en/java/javase/21/docs/specs/man/jpackage.html)
* [The jlink Command](https://docs.oracle.com/en/java/javase/21/docs/specs/man/jlink.html)
* [Oracle JDK 17 jpackage](https://docs.oracle.com/en/java/javase/17/jpackage/)
* [jpackage-maven-plugin](https://github.com/Akman/jpackage-maven-plugin)
* [maven-jpackage-template](https://github.com/wiverson/maven-jpackage-template)
* [JPackageScriptFX](https://github.com/dlemmermann/JPackageScriptFX)
* [Convert commons-lang jar to a module](https://github.com/codetojoy/easter_eggs_for_java_9/tree/master/egg_21_JLink_With_Converted_Jar)
* [JavaFx Tips](https://www.javacodegeeks.com/author/dirk-lemmermann)
