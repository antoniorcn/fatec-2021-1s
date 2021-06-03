package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    private TelaStrategy telaA = new TelaA();
    private TelaStrategy telaB = new TelaB();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 600, 400);

        FlowPane fp = new FlowPane();
        Button btnA = new Button("Tela A");
        Button btnB = new Button("Tela B");
        fp.getChildren().addAll(new Label("Menu Principal"), btnA, btnB);

        bp.setTop(fp);
        bp.setBottom(new Label("Barra de Status"));

        bp.setCenter(telaA.gerarTela());

        btnA.setOnAction((e) -> {
            bp.setCenter(telaA.gerarTela());
        });

        btnB.setOnAction((e) -> {
            bp.setCenter(telaB.gerarTela());
        });


        primaryStage.setScene(scn);
        primaryStage.setTitle("Tela Principal e SubTelas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);
    }
}
