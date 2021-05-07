package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class Manipulador implements EventHandler<ActionEvent> {
    private Label lbl;
    public Manipulador(Label lbl) {
        this.lbl = lbl;
    }
    public void handle(ActionEvent e) {
        this.lbl.setText("Hello World");
    }
}

public class BotaoMudandoLabelClasseExterna extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);
        Label lbl = new Label("Label");
        Button btn = new Button("Mudar Texto");

        Manipulador man = new Manipulador(lbl);

        btn.addEventFilter(ActionEvent.ACTION, man);
        bp.setTop(lbl);
        bp.setBottom(btn);
        stage.setScene(scn);
        stage.setTitle("Teste de TextField");
        stage.show();
    }
}
