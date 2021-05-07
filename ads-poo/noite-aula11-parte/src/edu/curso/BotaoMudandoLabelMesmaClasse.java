package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotaoMudandoLabelMesmaClasse extends Application
                                        implements EventHandler<ActionEvent> {
    Label lbl = new Label("Label");
    Button btn1 = new Button("A");
    Button btn2 = new Button("B");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);

        btn1.addEventFilter(ActionEvent.ACTION, this);
        btn2.setOnAction(this);

        bp.setTop(lbl);
        bp.setLeft(btn1);
        bp.setRight(btn2);
        stage.setScene(scn);
        stage.setTitle("Teste de TextField");
        stage.show();
    }

    public void handle(ActionEvent e) {
//        if (e.getSource() == btn1) {
//            lbl.setText("Hello World 1");
//        } else if (e.getSource() == btn2) {
//            lbl.setText("Hello World 2");
//        }

        Button b = (Button)e.getSource();
        lbl.setText( b.getText() );
    }
}
