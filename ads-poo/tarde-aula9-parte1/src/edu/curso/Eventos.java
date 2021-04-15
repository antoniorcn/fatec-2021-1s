package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Eventos extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Scene scn = new Scene(pane, 400, 200);

        Label lblTexto = new Label("Texto");
        Button btnOk = new Button("Ok");

        pane.setTop(lblTexto);
        pane.setBottom(btnOk);

        CodigoBotao cod = new CodigoBotao();
        btnOk.addEventFilter(ActionEvent.ANY, cod);

        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }
}
