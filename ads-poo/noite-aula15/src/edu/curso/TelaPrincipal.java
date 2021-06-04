package edu.curso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TelaPrincipal extends Application
            implements EventHandler<ActionEvent>, ExecutorAcoes {

    private TelaStrategy telaA = new TelaA(this);
    private TelaStrategy telaB = new TelaB(this);

    private BorderPane bp = new BorderPane();
    MenuBar menuBar = new MenuBar();
    private MenuItem mnuSair = new MenuItem("Sair");
    private MenuItem mnuTelaA = new MenuItem("Tela A");
    private MenuItem mnuTelaB = new MenuItem("Tela B");
    private MenuItem mnuOutroTelaB = new MenuItem("Outra Forma Tela B");

    private Button btnA = new Button("Tela A");
    private Button btnB = new Button("Tela B");

    private Map<String, TelaStrategy> mapaTelas = new HashMap<>();

    private void gerarMapaTelas() {
        mapaTelas.put("Tela A", telaA);
        mapaTelas.put("Tela B", telaB);
        mapaTelas.put("Outra Forma Tela B", telaB);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Painel Principal e Cena
        Scene scn = new Scene(bp, 600, 400);

        gerarMapaTelas();

        // Menus
        Menu mnuArquivo = new Menu("Arquivo");
        Menu mnuTelas = new Menu("Telas");

        menuBar.getMenus().addAll(mnuArquivo, mnuTelas);
        mnuArquivo.getItems().addAll(mnuSair);
        mnuTelas.getItems().addAll(mnuTelaA, mnuTelaB, mnuOutroTelaB);

        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(menuBar);

        mnuTelaA.setOnAction(this);
        mnuTelaB.setOnAction(this);
        mnuSair.setOnAction(this);
        mnuOutroTelaB.setOnAction(this);
        btnA.setOnAction(this);
        btnB.setOnAction(this);

        bp.setTop(fp);
        bp.setBottom(new Label("Barra de Status"));

        bp.setCenter(telaA.gerarTela());

        primaryStage.setScene(scn);
        primaryStage.setTitle("Tela Principal e SubTelas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);
    }

    public void executarAcao(String acao) {
        if ("Sair".equals(acao)) {
            Platform.exit();
            System.exit(0);
        } else if ("MENU_ON".equals(acao)) {
            menuBar.setDisable(false);
        } else if ("MENU_OFF".equals(acao)) {
            menuBar.setDisable(true);
        } else {
            TelaStrategy tela = mapaTelas.get(acao);
            if (tela != null) {
                bp.setCenter(tela.gerarTela());
            }
        }
    }

    @Override
    public void handle(ActionEvent event) {
        EventTarget target = event.getTarget();
        if (target instanceof MenuItem) {
            String acao = ((MenuItem)target).getText();
            executarAcao(acao);
        }
    }
}
