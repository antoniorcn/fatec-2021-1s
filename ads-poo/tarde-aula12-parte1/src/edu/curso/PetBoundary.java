package edu.curso;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.util.Arrays;
import java.util.List;

public class PetBoundary extends Application {
    private ObservableList<String> racas =
            FXCollections.observableArrayList("Dog Alemão", "Pastor Alemão",
                    "Poodle", "Lhasa", "Pincher");

    private TextField txtNome = new TextField();
    private ComboBox<String> cmbRaca = new ComboBox<>();
    private TextField txtPeso = new TextField();
    private PetControl control = new PetControl();
    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) throws Exception {
        cmbRaca.setItems(racas);
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 600, 400);

        gp.add(new Label("Nome"), 0, 0);
        gp.add(txtNome, 1, 0);
        gp.add(new Label("Raça"), 0, 1);
        gp.add(cmbRaca, 1, 1);
        gp.add(new Label("Peso"), 0, 2);
        gp.add(txtPeso, 1, 2);
        gp.add(btnAdicionar, 0, 3);
        gp.add(btnPesquisar, 1, 3);

        btnAdicionar.setOnAction((e) -> { control.adicionar();});
        btnPesquisar.setOnAction((e) -> { control.pesquisarPorNome();});

        StringConverter conversorStringDouble = new DoubleStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(cmbRaca.valueProperty(), control.racaProperty());
        Bindings.bindBidirectional(txtPeso.textProperty(), control.pesoProperty(), conversorStringDouble);

        stage.setScene(scn);
        stage.setTitle("Pets BCE Tradicional");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PetBoundary.class, args);
    }
}
