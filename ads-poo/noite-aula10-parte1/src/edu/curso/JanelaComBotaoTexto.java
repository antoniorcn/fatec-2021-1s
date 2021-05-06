package edu.curso;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JanelaComBotaoTexto extends Application {

    class AssinanteMouse implements EventHandler<MouseEvent> {
        public void handle(MouseEvent e) {
            // System.out.println("Botão Pressionado");
            System.out.print("Type=>" + e.getEventType());
            System.out.print("\tSource=>" + e.getSource());
            System.out.println("\tTarget=>" + e.getTarget());
        }
    }

    class AssinanteEvento implements EventHandler<MouseEvent> {
        private final boolean consumo;
        private String nome;

        public AssinanteEvento(String nome, boolean consumo) {
            this.nome = nome;
            this.consumo = consumo;
        }

        public void handle(MouseEvent e) {
            System.out.println(this.nome + " evento acionado");
            if (this.consumo) {
                e.consume();
            }
        }
    }

    class AssinanteTecla implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            System.out.print("Caracter=>" + event.getCode());
            System.out.print("\tSource=>" + event.getSource());
            System.out.println("\tTarget=>" + event.getTarget());
            if (event.getCode() == KeyCode.A) {
                event.consume();
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
            BorderPane bp = new BorderPane();
            Scene scn = new Scene(bp, 600, 400);

            Button btn = new Button("Me Aperte");
            Label lbl = new Label("Label");
            lbl.setText("Novo Texto");
            TextField txt = new TextField();
            txt.addEventFilter(KeyEvent.ANY, new AssinanteTecla());

            // AssinanteMouse a = new AssinanteMouse();

            stage.addEventFilter(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("STAGE CAPTURING", false));
            stage.addEventHandler(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("STAGE BUBBLING", false));

            scn.addEventFilter(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("SCENE CAPTURING", false));
            scn.addEventHandler(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("SCENE BUBBLING", false));

            bp.addEventFilter(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("PANE CAPTURING", true));
            bp.addEventHandler(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("PANE BUBBLING", false));

            btn.addEventFilter(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("BUTTON CAPTURING", false));
            btn.addEventHandler(MouseEvent.MOUSE_PRESSED, new AssinanteEvento("BUTTON BUBBLING", false));

            // btn.addEventFilter(MouseEvent.ANY, a);

            BorderPane.setAlignment(btn, Pos.CENTER);
            BorderPane.setAlignment(lbl, Pos.CENTER);
            BorderPane.setAlignment(txt, Pos.CENTER);

            bp.setCenter(txt);
            bp.setTop(lbl);
            bp.setBottom(btn);

            stage.setScene(scn);
            stage.setTitle("Teste de Evento com Botão e Texto");
            stage.show();
    }
}
