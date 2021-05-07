package edu.curso;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteTextField extends Application
            implements ChangeListener<String> {

    private TextField txt = new TextField("");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);

        bp.setCenter(txt);
        txt.textProperty().addListener(this);

        stage.setScene(scn);
        stage.setTitle("Teste de TextField");
        stage.show();
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        System.out.println(newValue);
        if (newValue.contains("a")) {
            String outroTexto = newValue.replace('a', '4');
            txt.setText(outroTexto);
        }
    }

}
