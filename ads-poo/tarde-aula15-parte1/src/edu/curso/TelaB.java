package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy {
    private FlowPane fp = new FlowPane();
    private ExecutarComando commander;

    public TelaB(ExecutarComando commander) {
        this.commander = commander;
        Button bp = new Button("Ir para outra tela");
        bp.setOnAction(
                (e)->{
                    commander.executarComando("TELAA");
                });
        fp.getChildren().addAll(new Label("Tela B"), new Label("DEtalhe do conteudo"), bp);
    }

    @Override
    public Pane fornecerConteudo() {
        return fp;
    }
}
