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

public class JanelaComBotao_Alt1 extends Application {

    class InterceptarEventos implements EventHandler<MouseEvent> {
        private Label label;
        InterceptarEventos(Label label) {
            this.label = label;
        }

        @Override
        public void handle(MouseEvent event) {
            // System.out.println("Apertado");
            label.setText("Apertado");
        }
    }

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
                new InterceptarEventos(lblTexto));

        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(JanelaComBotao_Alt1.class, args);
    }
}
