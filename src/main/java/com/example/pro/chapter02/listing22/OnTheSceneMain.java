package com.example.pro.chapter02.listing22;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OnTheSceneMain extends Application{
     DoubleProperty fillVals =  new SimpleDoubleProperty(255.0);
     Scene sceneRef;
    ObservableList cursors = FXCollections.observableArrayList(
        Cursor.DEFAULT,
        Cursor.CROSSHAIR,
        Cursor.WAIT,
        Cursor.TEXT,
        Cursor.HAND,
        Cursor.MOVE,
        Cursor.N_RESIZE,
        Cursor.NE_RESIZE,
        Cursor.E_RESIZE,
        Cursor.SE_RESIZE,
        Cursor.S_RESIZE,
        Cursor.SW_RESIZE,
        Cursor.W_RESIZE,
        Cursor.NW_RESIZE,
        Cursor.NONE
    );

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Slider sliderRef;
        ChoiceBox choiceBoxRef;
        Text textSceneX;
        Text textSceneY;
        Text textSceneW;
        Text textSceneH;
        Label labelStageX;
        Label labelStageY;
        Label labelStageW;
        Label labelStageH;


    }
}