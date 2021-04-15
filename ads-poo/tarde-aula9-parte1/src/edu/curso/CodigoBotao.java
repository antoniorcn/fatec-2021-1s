package edu.curso;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CodigoBotao implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Botão Apertado");
    }

}
