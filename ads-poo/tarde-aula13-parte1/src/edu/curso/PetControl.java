package edu.curso;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PetControl {
    private ObservableList<Pet> lista = FXCollections.observableArrayList();
    private TableView<Pet> table = new TableView<>();

    private StringProperty nome = new SimpleStringProperty("");
    public StringProperty nomeProperty() {
        return nome;
    }

    private StringProperty raca = new SimpleStringProperty("");
    public StringProperty racaProperty() {
        return raca;
    }

    private DoubleProperty peso = new SimpleDoubleProperty(0.0);
    public DoubleProperty pesoProperty() {
        return peso;
    }

    public Pet getEntity() {
        Pet p = new Pet();
        p.setNome(nome.get());
        p.setRaca(raca.get());
        p.setPeso(peso.get());
        return p;
    }
    private void setEntity(Pet p) {
        if (p != null) {
            nome.set(p.getNome());
            raca.set(p.getRaca());
            peso.set(p.getPeso());
        }
    }

    public void adicionar() {
        lista.add( getEntity() );
    }

    public void pesquisarPorNome() {
        for (Pet p : lista) {
            if (p.getNome().contains(nome.get())) {
                setEntity(p);
            }
        }
    }

    public void generateTable() {
        TableColumn<Pet, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Pet, String>("nome"));

        TableColumn<Pet, String> colRaca = new TableColumn<>("Raça");
        colRaca.setCellValueFactory(new PropertyValueFactory<Pet, String>("raca"));

        TableColumn<Pet, Double> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<Pet, Double>("peso"));

        table.getColumns().addAll(colNome, colRaca, colPeso);
        table.setItems(lista);
    }

    public TableView<Pet> getTable() {
        return table;
    }
}
