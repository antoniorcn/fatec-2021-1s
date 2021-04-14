package edu.curso;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TesteFormulario extends Application {

    public void start(Stage stage) {
        Label lblNome = new Label("Nome");
        TextField txtNome = new TextField();
        Button btnSalvar = new Button("Salvar");

        lblNome.setPrefSize(100.0, 30.0);
        txtNome.setPrefSize(250.0, 40.0);
        btnSalvar.setPrefSize(150.0, 20.0);

//        Pane pane = new Pane();
//        lblNome.relocate(10.0, 20.0);
//        txtNome.relocate(150.0, 20.0);
//        btnSalvar.relocate(10.0, 70.0);

//        FlowPane pane = new FlowPane();
//        pane.setHgap(20.0);
//        pane.setVgap(100.0);
//        pane.getChildren().addAll(lblNome, txtNome, btnSalvar);

//        BorderPane pane = new BorderPane();
//        FlowPane painel2 = new FlowPane();
//        painel2.getChildren().addAll(lblNome, txtNome);
//        pane.setTop(painel2);
//        pane.setBottom(btnSalvar);

//        TilePane pane = new TilePane();
//        pane.getChildren().addAll(lblNome, txtNome, btnSalvar);
//        pane.setPrefColumns(2);
//        pane.setHgap(15.0);
//        pane.setVgap(10.0);

//        GridPane pane = new GridPane();
//        pane.add(txtNome, 0, 0);
//        pane.add(lblNome, 1, 0);
//        pane.add(btnSalvar, 2, 0);
//        pane.setHgap(15.0);
//        pane.setVgap(15.0);

//        HBox pane = new HBox();
//        pane.getChildren().addAll(lblNome, txtNome, btnSalvar);

//        VBox pane = new VBox();
//        pane.getChildren().addAll(lblNome, txtNome, btnSalvar);

        HBox hpane = new HBox();
        hpane.setAlignment(Pos.CENTER_RIGHT);
        hpane.getChildren().addAll(btnSalvar);

        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(lblNome, txtNome, hpane);
        AnchorPane.setBottomAnchor(hpane, 15.0);
        AnchorPane.setRightAnchor(hpane, 15.0);
        AnchorPane.setLeftAnchor(hpane, 15.0);
        AnchorPane.setTopAnchor(lblNome, 15.0);
        AnchorPane.setLeftAnchor(lblNome, 15.0);
        AnchorPane.setTopAnchor(txtNome, 50.0);
        AnchorPane.setLeftAnchor(txtNome, 15.0);
        AnchorPane.setRightAnchor(txtNome, 15.0);
        AnchorPane.setBottomAnchor(txtNome, 50.0);

        Scene scn = new Scene(pane, 640, 480);
        stage.setScene(scn);
        stage.setTitle("Teste de Formulario");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteFormulario.class, args);
    }
}
