package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy {
    @Override
    public Pane gerarConteudo() {
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(new Label("Tela A"));
        return fp;
    }
}
