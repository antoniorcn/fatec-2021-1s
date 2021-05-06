package edu.curso;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Janela extends Application {

    class InterceptarEventos implements EventHandler<MouseEvent> {
        private String nome;
        private boolean consume;

        InterceptarEventos(String nome, boolean consume) {
            this.nome = nome;
            this.consume = consume;
        }
        @Override
        public void handle(MouseEvent event) {
            System.out.print("Nome ==> "+ this.nome);
            System.out.print("\tSource ==>" + event.getSource());
            System.out.print("\tTipo ==>" + event.getEventType());
            System.out.println("\tTarget ==>" + event.getTarget());
            if (this.consume) {
                event.consume();
            }
        }
    }

    @Override
    public void start(Stage stage) {
        BorderPane principal = new BorderPane();
        Scene scn = new Scene(principal, 600, 400);

        stage.addEventFilter(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("FILTER STAGE", false));
        stage.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("HANDLER STAGE", false));

        scn.addEventFilter(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("FILTER SCENE", false));
        scn.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("HANDLER SCENE", false));

        principal.addEventFilter(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("FILTER PANE", true));
        principal.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new InterceptarEventos("HANDLER PANE", false));
        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Janela.class, args);
    }
}
