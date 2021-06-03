package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

class NossoConversorString extends StringConverter<LocalDate> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString(LocalDate object) {
        if (object != null) {
            return object.format(formatter);
        } else {
            return "";
        }
    }

    @Override
    public LocalDate fromString(String string) {
        try {
            System.out.print("Convertendo data --> " + string);
            LocalDate d = LocalDate.parse(string);
            System.out.println("para --> " + d);
            return(d);
        } catch (Exception e) {
            return null;
        }
    }
}

public class PetBoundary extends Application {
    private ObservableList<String> racas =
            FXCollections.observableArrayList("Dog Alemão", "Pastor Alemão",
                    "Poodle", "Lhasa", "Pincher");

    private TextField txtNome = new TextField();
    private ComboBox<String> cmbRaca = new ComboBox<>();
    private TextField txtPeso = new TextField();
    // private TextField txtNascimento = new TextField();
    private DatePicker txtNascimento = new DatePicker(LocalDate.now());
    private PetControl control = new PetControl();
    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) throws Exception {
        cmbRaca.setItems(racas);
        BorderPane panePrincipal = new BorderPane();
        GridPane gp = new GridPane();
        Scene scn = new Scene(panePrincipal, 600, 400);
        panePrincipal.setTop(gp);

        gp.add(new Label("Nome"), 0, 0);
        gp.add(txtNome, 1, 0);
        gp.add(new Label("Raça"), 0, 1);
        gp.add(cmbRaca, 1, 1);
        gp.add(new Label("Peso"), 0, 2);
        gp.add(txtPeso, 1, 2);
        gp.add(new Label("Nascimento"), 0, 3);
        gp.add(txtNascimento, 1, 3);
        gp.add(btnAdicionar, 0, 4);
        gp.add(btnPesquisar, 1, 4);

        control.generateTable();
        panePrincipal.setCenter(control.getTable());

        btnAdicionar.setOnAction((e) -> { control.adicionar();});
        btnPesquisar.setOnAction((e) -> { control.pesquisarPorNome();});

        StringConverter conversorStringDouble = new DoubleStringConverter();
        StringConverter conversorStringLocalDate = new LocalDateStringConverter();
        // StringConverter conversorStringLocalDate = new NossoConversorString();

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(cmbRaca.valueProperty(), control.racaProperty());
        Bindings.bindBidirectional(txtPeso.textProperty(), control.pesoProperty(), conversorStringDouble);
        Bindings.bindBidirectional(txtNascimento.valueProperty(), control.nascimentoProperty());

        stage.setScene(scn);
        stage.setTitle("Pets BCE Tradicional");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PetBoundary.class, args);
    }
}
