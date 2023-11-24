module com.example.javafx {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.javafx to javafx.fxml;
  exports com.example.javafx;

  exports com.example.demo to javafx.graphics;
  opens com.example.pro.chapter01.listing11 to javafx.graphics;
  opens com.example.pro.chapter01.listing12 to javafx.graphics;
  opens com.example.pro.chapter01.listing13 to javafx.graphics;
  opens com.example.pro.chapter02.listing21 to javafx.graphics;
  opens com.example.pro.chapter02.listing22 to javafx.graphics;
}