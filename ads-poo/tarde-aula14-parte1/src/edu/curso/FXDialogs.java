package edu.curso;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class FXDialogs {

    public static void show(String title, String headerText, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        alert.showAndWait();
    }

}