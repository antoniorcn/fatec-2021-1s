package edu.curso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TelaPrincipal extends Application
        implements EventHandler<ActionEvent>, ExecutarComando {

    private Button btnA = new Button("A");
    private Button btnB = new Button("B");
    private Button btnB2 = new Button("Outro jeito de acionar a Tela B");
    private BorderPane bp = new BorderPane();
    private TelaStrategy telaA = new TelaA(this);
    private TelaStrategy telaB = new TelaB(this);

    private MenuItem menuA = new MenuItem("Tela A");
    private MenuItem menuB = new MenuItem("Tela B");
    private MenuItem menuSair = new MenuItem("Sair");

    private Map<String, TelaStrategy> mapaTelas = new HashMap<>();

    private void gerarMapaTelas() {
        mapaTelas.clear();
        mapaTelas.put("TELAA", telaA);
        mapaTelas.put("TELAB", telaB);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scn = new Scene(bp, 600, 400);

//        FlowPane paneMenu = new FlowPane();
//        paneMenu.getChildren().addAll(new Label("Menu"), btnA, btnB, btnB2);
        MenuBar menuBar = new MenuBar();

        Menu mnuArquivo = new Menu("Arquivo");
        Menu mnuTelas = new Menu("Telas");

        menuBar.getMenus().addAll(mnuArquivo, mnuTelas);


        mnuArquivo.getItems().add(menuSair);
        mnuTelas.getItems().addAll(menuA, menuB);

        btnA.setId("TELAA");
        btnB.setId("TELAB");

        menuA.setId("TELAA");
        menuB.setId("TELAB");

        btnA.setOnAction(this);
        btnB.setOnAction(this);
        btnB2.setOnAction(this);

        menuA.setOnAction(this);
        menuB.setOnAction(this);
        menuSair.setOnAction(this);

        gerarMapaTelas();

        bp.setCenter(telaA.fornecerConteudo());

        bp.setTop(menuBar);
        bp.setBottom(new Label("Barra de Status"));
        bp.setLeft(new Label("Opções"));

        primaryStage.setScene(scn);
        primaryStage.setTitle("Teste de Janelas Multiplas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() == menuSair) {
            Platform.exit();
            System.exit(0);
        } else {
            String id = "TELAA";
            Object obj = event.getTarget();
            if (obj instanceof Button) {
                id = ((Button)obj).getId();
            } else if (obj instanceof MenuItem) {
                id = ((MenuItem)obj).getId();
            }
            executarComando(id);
        }
    }

    @Override
    public void executarComando(String cmd) {
        TelaStrategy tela = mapaTelas.get(cmd);
        bp.setCenter(tela.fornecerConteudo());
    }
}
