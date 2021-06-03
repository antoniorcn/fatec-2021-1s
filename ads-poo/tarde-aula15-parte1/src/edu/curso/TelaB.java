package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy {
    @Override
    public Pane gerarConteudo() {
        FlowPane fp = new FlowPane();
        Button bp = new Button("Ir para outra tela");
        fp.getChildren().addAll(new Label("Tela B"), new Label("DEtalhe do conteudo"), bp);
        return fp;
    }
}
