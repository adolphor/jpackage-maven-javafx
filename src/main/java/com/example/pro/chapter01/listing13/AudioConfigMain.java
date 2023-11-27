package com.example.pro.chapter01.listing13;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @Author: HongBo.Zhu
 * @Date: 2022/4/7 14:43
 * @Email: 0haizhu0@gmail.com
 */
public class AudioConfigMain extends Application {

  // A reference to the model
  AudioConfigModel acModel = new AudioConfigModel();

  Text textDb;
  Slider dbSlider;
  CheckBox mutingCheckBox;
  ChoiceBox genreChoiceBox;
  Color color = Color.color(0.66, 0.67, 0.69);

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    // 标题
    Text title = new Text(65, 12, "Audio Configuration");
    title.setTextOrigin(VPos.TOP);
    title.setFill(Color.WHITE);
    title.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));

    // 分贝
    Text dbText = new Text();
    dbText.setLayoutX(18);
    dbText.setLayoutY(69);
    dbText.setTextOrigin(VPos.TOP);
    dbText.setFill(Color.web("#131021"));
    dbText.setFont(Font.font("SansSerif", FontWeight.BOLD, 18));

    // 是否静音
    Text mutingText = new Text(18, 113, "Muting");
    mutingText.setTextOrigin(VPos.TOP);
    mutingText.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
    mutingText.setFill(Color.web("#131021"));

    // 音乐流派
    Text genreText = new Text(18, 154, "Genre");
    genreText.setTextOrigin(VPos.TOP);
    genreText.setFill(Color.web("#131021"));
    genreText.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));

    // 滚动条
    dbSlider = new Slider();
    dbSlider.setLayoutX(135);
    dbSlider.setLayoutY(69);
    dbSlider.setPrefWidth(162);
    dbSlider.setMin(acModel.minDecibels);
    dbSlider.setMax(acModel.maxDecibels);

    // 是否静音
    mutingCheckBox = new CheckBox();
    mutingCheckBox.setLayoutX(280);
    mutingCheckBox.setLayoutY(113);

    // 音乐流派
    genreChoiceBox = new ChoiceBox();
    genreChoiceBox.setLayoutX(204);
    genreChoiceBox.setLayoutY(154);
    genreChoiceBox.setPrefWidth(93);
    genreChoiceBox.setItems(acModel.genres);

    // 标题区域：背景颜色渐变的长方形
    Stop[] stops = new Stop[]{
        new Stop(0, Color.web("0xAEBBCC")),
        new Stop(1, Color.web("0x6D84A3"))
    };
    LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
    Rectangle titleRectangle = new Rectangle(0, 0, 320, 45);
    titleRectangle.setFill(linearGradient);

    // 内容容器区域：设置背景色
    Rectangle contentRectangle = new Rectangle(0, 43, 320, 300);
    contentRectangle.setFill(Color.rgb(199, 206, 213));

    // 工作内容区域：设置背景色
    Rectangle workRectangle = new Rectangle(8, 54, 300, 130);
    workRectangle.setArcHeight(20);
    workRectangle.setArcWidth(20);
    workRectangle.setFill(Color.WHITE);
    workRectangle.setStroke(color);

    // 分贝和静音分隔线
    Line lineDbAndMuting = new Line(9, 97, 309, 97);
    lineDbAndMuting.setStroke(color);

    // 静音和流派分隔线
    Line lineMutingAndGenre = new Line(9, 141, 309, 141);
    lineMutingAndGenre.setFill(color);

    // 分组：注意图层顺序，后面的node会覆盖前面的node
    Group group = new Group(
        titleRectangle, title, // 标题
        contentRectangle, workRectangle, // 内容
        dbText, dbSlider, // 分贝和滑动条
        lineDbAndMuting, // 分割线
        mutingText, mutingCheckBox, // 静音和选择器
        lineMutingAndGenre, // 分割线
        genreText, genreChoiceBox // 流派和选择器
    );

    /** 事件绑定 */
    // 文字绑定值
    dbText.textProperty().bind(acModel.selectedDBs.asString().concat(" dB"));
    // 滑动条绑定值
    dbSlider.valueProperty().bindBidirectional(acModel.selectedDBs);
    // 滑动条绑定是否可编辑
    dbSlider.disableProperty().bind(acModel.muting);
    // 复选框绑定状态
    mutingCheckBox.selectedProperty().bindBidirectional(acModel.muting);
    // 选择器绑定值
    acModel.genreSelectionModel = genreChoiceBox.getSelectionModel();
    acModel.addListenerToGenreSelectionModel();
    acModel.genreSelectionModel.selectFirst();

    // 基础设置：stage 和 scene
    Scene scene = new Scene(group, 320, 343);
    stage.setScene(scene);
    stage.setTitle("Audio Configuration");
    stage.show();
  }

}
