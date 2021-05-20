package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteBinding extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 300, 200);

        TextField txtValor = new TextField();
        Button btn = new Button("Ok");

        StringProperty strValor = new SimpleStringProperty();
        strValor.addListener(
                (observable, antigo, novo) -> {
                    System.out.println("strValor alterado   de: " + antigo + "   para: " + novo);
                }
        );

//        btn.setOnAction((e) -> {
            // System.out.println(txtValor.getText());
            // strValor.set( txtValor.getText() );
//        });

        Bindings.bindBidirectional(txtValor.textProperty(), strValor);

        strValor.set("Ola Mundo");

        bp.setTop(txtValor);
        bp.setBottom(btn);

        stage.setScene(scn);
        stage.setTitle("Teste de Binding");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteBinding.class, args);
    }
}
