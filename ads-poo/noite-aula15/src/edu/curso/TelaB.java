package edu.curso;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy {

    private ExecutorAcoes executor;

    public TelaB(ExecutorAcoes executor) {
        this.executor = executor;
    }

    @Override
    public Pane gerarTela() {
        FlowPane telaB = new FlowPane();
        Button btn = new Button("Acessar a Tela A");
        btn.setOnAction((e)->{
            executor.executarAcao("Tela A");
        });
        telaB.getChildren().addAll(new Label("Tela B"), btn);
        return telaB;
    }

}
