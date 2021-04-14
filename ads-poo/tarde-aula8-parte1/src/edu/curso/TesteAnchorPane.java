package edu.curso;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class TesteAnchorPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();
        Scene scn = new Scene(pane, 640, 480);
        URL estilos = getClass().getResource("estilos.css");
        scn.getStylesheets().add(estilos.toString());
        Label lblPath = new Label(estilos.getPath());
        Label lblFile = new Label(estilos.getFile());
        Label lblNome = new Label(estilos.toString());
        lblNome.setId("nome");
        // lblNome.getStyleClass().add("estranha");
        TextField txtNome = new TextField();
        Button btnSalvar = new Button("Salvar");

        //        // lblNome.setFont(new Font("arial", 32.0));
        //        lblNome.setStyle("-fx-font-size: 48; -fx-text-fill: red");

        AnchorPane.setTopAnchor(lblNome, 10.0);
        AnchorPane.setLeftAnchor(lblNome, 20.0);

        AnchorPane.setTopAnchor(lblPath, 100.0);
        AnchorPane.setLeftAnchor(lblPath, 20.0);

        AnchorPane.setTopAnchor(lblFile, 150.0);
        AnchorPane.setLeftAnchor(lblFile, 20.0);

        AnchorPane.setLeftAnchor(txtNome, 20.0);
        AnchorPane.setTopAnchor(txtNome, 10.0);
        pane.getChildren().add(txtNome);
        pane.getChildren().addAll(lblNome, lblPath, lblFile);
        //double y1 = AnchorPane.getBottomAnchor(txtNome);
        AnchorPane.setBottomAnchor(btnSalvar, 10.0);
        AnchorPane.setLeftAnchor(btnSalvar, 20.0);
        pane.getChildren().add(btnSalvar);

        stage.setScene(scn);
        stage.setTitle("Teste de AnchorPane");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(TesteAnchorPane.class, args);
    }
}
