package edu.curso.jfxpropriedades;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteTela extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);

        Label lblTexto = new Label("Este texto é um label");
        TextField txtTexto = new TextField();

        bp.setTop(lblTexto);
        bp.setBottom(txtTexto);

//        txtTexto.textProperty().addListener((obs, antigo, novo)->{
//            // System.out.println("Valor antigo ->" + antigo + "      valor novo ->" + novo);
//            lblTexto.setText(novo);
//        });
//         txtTexto.textProperty().bind(lblTexto.textProperty());
        Bindings.bindBidirectional(txtTexto.textProperty(), lblTexto.textProperty());

        stage.setScene(scn);
        stage.setTitle("Propriedades do JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
