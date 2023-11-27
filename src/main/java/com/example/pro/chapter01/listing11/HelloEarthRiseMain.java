package com.example.pro.chapter01.listing11;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.pro.Constant.PROJECT_PATH;

/**
 * @Author: HongBo.Zhu
 * @Date: 2022/4/6 16:42
 * @Email: 0haizhu0@gmail.com
 */
public class HelloEarthRiseMain extends Application {

  private static final String message = "Earthrise at Christmas: "
      + "[Forty] years ago this Christmas, a turbulent world "
      + "looked to the heavens for a unique view of our home "
      + "planet. This photo of Earthrise over the lunar horizon "
      + "was taken by the Apollo 8 crew in December 1968, showing "
      + "Earth for the first time as it appears from deep space. "
      + "Astronauts Frank Borman, Jim Lovell and William Anders "
      + "had become the first humans to leave Earth orbit, "
      + "entering lunar orbit on Christmas Eve. In a historic live "
      + "broadcast that night, the crew took turns reading from "
      + "the Book of Genesis, closing with a holiday wish from "
      + "Commander Borman: \"We close with good night, good luck, "
      + "a Merry Christmas, and God bless all of you -- all of "
      + "you on the good Earth.\"";

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    /** Reference to the Text */
    Text textRef = new Text(message);
    // 距离顶部100像素
    textRef.setLayoutY(100);
    textRef.setTextOrigin(VPos.TOP);
    textRef.setTextAlignment(TextAlignment.JUSTIFY);
    textRef.setWrappingWidth(800);
    // 设置文字颜色
    textRef.setFill(Color.rgb(187, 195, 107));
    // 设置字体
    textRef.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));

    /** Provides the animated scrolling behavior for the text */
    // 滚动时间：75000ms
    TranslateTransition transTransition = new TranslateTransition(new Duration(75000), textRef);
    // 滚动距离：到Y轴负值超过文字高度就行
    transTransition.setToY(-820);
    transTransition.setInterpolator(Interpolator.LINEAR);
    transTransition.setCycleCount(Timeline.INDEFINITE);

    // Create an ImageView containing the image
    Image image = new Image("file://" + PROJECT_PATH + "/src/main/resources/images/pro/chapter01/listing11/Earthrise.jpg");
    ImageView imageView = new ImageView(image);

    // Create a Group containing the text
    Group textGroup = new Group(textRef);
    textGroup.setLayoutX(50);
    textGroup.setLayoutY(180);
    textGroup.setClip(new Rectangle(830, 120));

    // Combine ImageView and Group
    Group root = new Group(imageView, textGroup);

    Scene scene = new Scene(root, 916, 787);
    stage.setScene(scene);
    stage.setTitle("Hello Earthrise");
    stage.show();
    // Start the text animation
    transTransition.play();
  }

}
