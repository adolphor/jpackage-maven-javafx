package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX 开发环境测试
 *
 * @Author: HongBo.Zhu
 * @Date: 2022/4/7 09:40
 * @Email: 0haizhu0@gmail.com
 */
public class HelloFX extends Application {

  /**
   * 必须覆写此方法，完成页面渲染
   */
  @Override
  public void start(Stage stage) {
    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    Scene scene = new Scene(new StackPane(l), 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Javafx程序入口
   * @param args
   */
  public static void main(String[] args) {
    // 调用父类的静态启动方法
    Application.launch(args);
  }

}