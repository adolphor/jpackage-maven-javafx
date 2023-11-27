/**
 * 参考：https://gluonhq.com/create-native-javafx-applications-using-graalvm-22-builds-from-gluon/
 * 下载：https://github.com/gluonhq/graal/releases
 *
 * https://github.com/gluonhq/gluon-samples
 * https://docs.gluonhq.com/#_hellofx
 *
 * 简单测试GraalVM的范例：
 * 编译：javac HelloWorld.java
 * 转换：native-image HelloWorld
 * 运行：./HelloWorld
 */
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, Native World!");
  }
}
