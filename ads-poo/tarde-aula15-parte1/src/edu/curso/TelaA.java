package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy {
    private FlowPane fp = new FlowPane();
    private ExecutarComando commander;

    public TelaA(ExecutarComando commander) {
        this.commander = commander;
        fp.getChildren().addAll(new Label("Tela A"));
    }

    @Override
    public Pane fornecerConteudo() {
        return fp;
    }
}
