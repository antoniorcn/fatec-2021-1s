package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotaoMudandoLabelClasseAnonima extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);
        Label lbl = new Label("Label");

        Button btn1 = new Button("Mudar Texto 1");
        Button btn2 = new Button("Mudar Texto 2");

        btn1.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Hello World 1");
            }
        });

        btn2.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Hello World 2");
            }
        });

        bp.setTop(lbl);
        bp.setLeft(btn1);
        bp.setRight(btn2);
        stage.setScene(scn);
        stage.setTitle("Teste de TextField");
        stage.show();
    }
}
