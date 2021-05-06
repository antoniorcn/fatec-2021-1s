package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JanelaComBotao_Alt3 extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane principal = new BorderPane();
        Scene scn = new Scene(principal, 600, 400);

        Button btn = new Button("Me Aperte");
        Label lblTexto = new Label("Texto");

        principal.setTop(lblTexto);
        principal.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.CENTER);
        BorderPane.setAlignment(lblTexto, Pos.CENTER);

        btn.addEventFilter(MouseEvent.MOUSE_PRESSED,
                (event) -> {
                    lblTexto.setText("Apertado jeito 2");
                });

        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(JanelaComBotao_Alt3.class, args);
    }
}
