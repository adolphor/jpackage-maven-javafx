package com.example.pro.chapter01.listing13;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SingleSelectionModel;

/**
 * @Author: HongBo.Zhu
 * @Date: 2022/4/7 14:46
 * @Email: 0haizhu0@gmail.com
 */
public class AudioConfigModel {
  /**
   * 最小分贝
   */
  public double minDecibels = 0.0;
  /**
   * 最大分贝
   */
  public double maxDecibels = 160.0;
  /**
   * 当前调整值
   */
  public IntegerProperty selectedDBs = new SimpleIntegerProperty(0);
  /**
   * 是否静音
   */
  public BooleanProperty muting = new SimpleBooleanProperty(false);
  /**
   * 音乐流派列表
   */
  public ObservableList genres = FXCollections.observableArrayList(
      "Chamber",
      "Country",
      "Cowbell",
      "Metal",
      "Polka",
      "Rock"
  );
  /**
   * 滑动条选择器模型
   */
  public SingleSelectionModel genreSelectionModel;

  /**
   * Adds a change listener to the selection model of the ChoiceBox,
   * and contains * code that executes when the selection in the ChoiceBox changes.
   */
  public void addListenerToGenreSelectionModel() {
    genreSelectionModel.selectedIndexProperty().addListener(
        (Observable o) -> {
          int selectedIndex = genreSelectionModel.selectedIndexProperty().getValue();
          switch (selectedIndex) {
            case 0:
              selectedDBs.setValue(80);
              break;
            case 1:
              selectedDBs.setValue(100);
              break;
            case 2:
              selectedDBs.setValue(150);
              break;
            case 3:
              selectedDBs.setValue(140);
              break;
            case 4:
              selectedDBs.setValue(120);
              break;
            case 5:
              selectedDBs.setValue(130);
          }
        }
    );
  }
}
