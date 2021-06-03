package edu.curso;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy {

    @Override
    public Pane gerarTela() {
        FlowPane telaA = new FlowPane();
        telaA.getChildren().addAll(new Label("Tela A"));
        return telaA;
    }

}
