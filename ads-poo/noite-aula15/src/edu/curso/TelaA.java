package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy {

    private ExecutorAcoes executor;

    public TelaA(ExecutorAcoes executor) {
        this.executor = executor;
    }

    @Override
    public Pane gerarTela() {
        FlowPane telaA = new FlowPane();
        Button btn = new Button("Sair");
        btn.setOnAction( (e)-> {
            executor.executarAcao("Sair");
        });

        Button btnDesligaMenu = new Button("Desliga Menu");
        btnDesligaMenu.setOnAction((e) -> {
            executor.executarAcao("MENU_OFF");
        });

        Button btnLigaMenu = new Button("Liga Menu");
        btnLigaMenu.setOnAction((e) -> {
            executor.executarAcao("MENU_ON");
        });


        telaA.getChildren().addAll(new Label("Tela A"), btn, btnLigaMenu, btnDesligaMenu);
        return telaA;
    }

}
