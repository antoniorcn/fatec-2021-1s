package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);

        FlowPane paneMenu = new FlowPane();
        Button btnA = new Button("A");
        Button btnB = new Button("B");
        paneMenu.getChildren().addAll(new Label("Menu"), btnA, btnB);

        TelaStrategy tela = new TelaB();

        btnA.setOnAction( (e) -> {
            bp.setCenter(new TelaA().gerarConteudo());
        });

        btnB.setOnAction( (e) -> {
            bp.setCenter(new TelaB().gerarConteudo());
        });

        bp.setCenter(tela.gerarConteudo());

        bp.setTop(paneMenu);
        bp.setBottom(new Label("Barra de Status"));
        bp.setLeft(new Label("Opções"));

        primaryStage.setScene(scn);
        primaryStage.setTitle("Teste de Janelas Multiplas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);
    }
}
