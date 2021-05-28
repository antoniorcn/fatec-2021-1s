package edu.curso.jfxpropriedades;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TestePropriedades {

    public static void main(String[] args) {

        StringProperty titulo = new SimpleStringProperty("");

//        titulo.addListener(new ChangeListener<String>() {
////            @Override
////            public void changed(ObservableValue<? extends String> observable,
////                                String oldValue,
////                                String newValue) {
////                System.out.println("O titulo foi mudado de: " +
////                        oldValue + "   para: " + newValue);
////            }
////        });

        titulo.addListener((observable, antigo, novo)->{
            System.out.println("O titulo foi mudado de: " +
                    antigo + "   para: " + novo);
        });

        titulo.set("Green Mile");
        titulo.set("Codigo Limpo");


    }
}
