package edu.curso;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class PetControl {
    private List<Pet> lista = new ArrayList<>();

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
}
