package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Calculadora extends Application {
    private final static List<String> botoes = Arrays.asList(
            "1", "2", "3", "+",
            "4", "5", "6", "-",     // 7 / 4 = 1        7 % 4 = 3
            "7", "8", "9", "*",     // 10 / 4 = 2       10 % 4 = 3
            ".", "0", "=", "/" );

    @Override
    public void start(Stage stage) {
        AnchorPane panPrincipal = new AnchorPane();
        AnchorPane panDisplay = new AnchorPane();
        panDisplay.setStyle("-fx-background-color: red");
        GridPane panBotoes = new GridPane();
        panBotoes.setStyle("-fx-background-color: green; -fx-padding: 10px");

        AnchorPane.setTopAnchor(panDisplay, 5.0);
        AnchorPane.setLeftAnchor(panDisplay, 5.0);
        AnchorPane.setRightAnchor(panDisplay, 5.0);

        AnchorPane.setBottomAnchor(panBotoes, 10.0);
        AnchorPane.setLeftAnchor(panBotoes, 10.0);
        AnchorPane.setRightAnchor(panBotoes, 10.0);
        AnchorPane.setTopAnchor(panBotoes, 60.0);

        panPrincipal.getChildren().addAll(panDisplay, panBotoes);

        TextField txtDisplay = new TextField();
        Button btnCE = new Button("CE");

        AnchorPane.setTopAnchor(txtDisplay, 0.0);
        AnchorPane.setLeftAnchor(txtDisplay, 0.0);
        AnchorPane.setBottomAnchor(txtDisplay, 0.0);
        AnchorPane.setRightAnchor(txtDisplay, 50.0);

        AnchorPane.setTopAnchor(btnCE, 10.0);
        AnchorPane.setRightAnchor(btnCE, 10.0);
        AnchorPane.setBottomAnchor(btnCE, 10.0);

        panDisplay.getChildren().addAll(txtDisplay, btnCE);
//        panBotoes.setPrefColumns(4);
//        for (String nomeBotao : botoes) {
//            Button btn = new Button(nomeBotao);
//            panBotoes.getChildren().add(btn);
//        }
        panBotoes.setHgap(10.0);
        panBotoes.setVgap(10.0);

        for (int i = 0; i < botoes.size(); i++) {
            String nomeBotao = botoes.get(i);
            int row = i / 4;
            int col = i % 4;
            Button btn = new Button(nomeBotao);
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setHgrow(btn, Priority.ALWAYS);
            GridPane.setVgrow(btn, Priority.ALWAYS);
            panBotoes.add(btn, col, row);
        }
        Scene scn = new Scene(panPrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Calculadora");
        stage.show();
    }
}
