// 参考：https://segmentfault.com/a/1190000013409571
module com.example.javafx {
  requires javafx.controls;
  requires javafx.fxml;

  // open：反射
  // -- open module：该模块下的所有的包在runtime都允许deep reflection
  // -- opens package：用于声明该模块的指定包在runtime允许使用反射访问
  opens com.example.javafx to javafx.fxml;

  // exports：表示允许在编译时和运行时访问指定包的public成员
  // -- exports：对所有module开放
  // -- exports to：对指定module开放
  exports com.example.javafx to javafx.graphics;
  exports com.example.demo to javafx.graphics;
  exports com.example.pro.chapter01.listing11 to javafx.graphics;
  exports com.example.pro.chapter01.listing12 to javafx.graphics;
  exports com.example.pro.chapter01.listing13 to javafx.graphics;

}