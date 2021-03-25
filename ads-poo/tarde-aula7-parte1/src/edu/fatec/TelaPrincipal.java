package edu.fatec;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    public void start(Stage stage){
        // TilePane pane = new TilePane();
        BorderPane pane = new BorderPane();
        // HBox pane = new HBox();
        // pane.setHgap(20);
        Scene scn = new Scene(pane);
        Label lblHello = new Label("Hello World Java FX");

        Button btn = new Button("Ok");

        Label lblOutro = new Label("Outro Texto");

        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");
        Button btnCancel = new Button("Cancel");

        // pane.getChildren().add(lblHello);
        // pane.setTop(lblHello);

        // pane.getChildren().add(btn);
        // pane.setBottom(btn);
        // btn.relocate(100, 50);
        // pane.setPrefColumns(2);
        // pane.getChildren().addAll(lblHello, btn, lblOutro);
        pane.setTop(lblHello);
        pane.setLeft(btn);
        pane.setRight(lblOutro);

        GridPane paneBotoes = new GridPane();
        paneBotoes.setHgap(100);
        paneBotoes.add(btnYes, 0, 0);
        paneBotoes.add(btnNo, 1, 0);
        paneBotoes.add(btnCancel, 2, 0);

        pane.setBottom(paneBotoes);
        // pane.add(lblHello, 0, 0);
        // pane.add(btn, 1, 0);
        // pane.add(lblOutro, 2, 0);

        stage.setScene(scn);
        stage.setTitle("Minha primeira janela JavaFX");
        stage.setWidth(200);
        stage.setHeight(100);
        stage.show();
    }
    public static void main(String[] args) {
        System.out.println("Teste de Java FX");
        Application.launch(TelaPrincipal.class, args);
    }
}
