package edu.curso;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy {

    @Override
    public Pane gerarTela() {
        FlowPane telaB = new FlowPane();
        telaB.getChildren().addAll(new Label("Tela B"));
        return telaB;
    }

}
