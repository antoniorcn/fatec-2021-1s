package edu.curso.jfxpropriedades;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteProperties2 {
    public static void main(String[] args) {

        String valorA = new String("A");
        System.out.println("Valor Inicial ==> " + valorA);
        valorA = "AAA";
        System.out.println("Valor Atual ==> " + valorA);

        StringProperty valorB = new SimpleStringProperty("B");
//        valorB.addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//
//            }
//        });
        valorB.addListener((ob, antigo, novo) -> {
            System.out.println("ValorB foi alterado de " + antigo + " para " + novo);
        });

        System.out.println("Valor Inicial ==> " + valorB.get());
        valorB.set("BBB");
        System.out.println("Valor Atual ==> " + valorB.get());

        valorB.set("CCCC");
    }
}
