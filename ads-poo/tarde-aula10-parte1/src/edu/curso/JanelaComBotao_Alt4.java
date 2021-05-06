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

public class JanelaComBotao_Alt4 extends Application implements EventHandler<MouseEvent> {
    private Button btn;
    private Button btn2;
    private Label lblTexto;

    @Override
    public void start(Stage stage) {
        BorderPane principal = new BorderPane();
        Scene scn = new Scene(principal, 600, 400);

        btn = new Button("Me Aperte");
        btn2 = new Button("Me Aperte2");
        lblTexto = new Label("Texto");

        principal.setTop(lblTexto);
        principal.setBottom(btn);
        principal.setRight(btn2);
        BorderPane.setAlignment(btn, Pos.CENTER);
        BorderPane.setAlignment(lblTexto, Pos.CENTER);

        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, this);
        btn2.addEventFilter(MouseEvent.MOUSE_PRESSED, this);

        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSource());
        if (event.getSource() == btn) {
            lblTexto.setText("Texto do Botão 1");
        } else if (event.getSource() == btn2) {
            lblTexto.setText("Texto do Botão 2");
        }
    }


    public static void main(String[] args) {
        Application.launch(JanelaComBotao_Alt4.class, args);
    }


}
