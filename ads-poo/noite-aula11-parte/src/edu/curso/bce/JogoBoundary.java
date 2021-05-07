package edu.curso.bce;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JogoBoundary extends Application implements EventHandler<ActionEvent> {

    private TextField txtId = new TextField();
    private TextField txtTitulo = new TextField();
    private TextField txtGenero = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private List<Jogo> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 600, 300);

        Label lblId = new Label("Id");
        Label lblTitulo = new Label("Titulo");
        Label lblGenero = new Label("Genero");

        gp.add(lblId, 0, 0);
        gp.add(txtId, 1, 0);
        gp.add(lblTitulo, 0, 1);
        gp.add(txtTitulo, 1, 1);
        gp.add(lblGenero, 0, 2);
        gp.add(txtGenero, 1, 2);
        gp.add(btnAdicionar, 0, 3);
        gp.add(btnPesquisar, 1, 3);

        btnAdicionar.setOnAction(this);
        btnPesquisar.setOnAction(this);

        stage.setScene(scn);
        stage.setTitle("Loja de Jogos");
        stage.show();
    }


    public Jogo boundaryToEntity() {
        Jogo j = new Jogo();
        j.setId(  Long.parseLong(txtId.getText()) );
        j.setTitulo( txtTitulo.getText() );
        j.setGenero( txtGenero.getText() );
        return j;
    }

    public void entityToBoundary(Jogo j) {
        txtTitulo.setText( j.getTitulo() );
        txtGenero.setText( j.getGenero() );
        txtId.setText( String.valueOf(j.getId()) );
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnAdicionar) {
            Jogo j = boundaryToEntity();
            lista.add(j);
        } else if (event.getSource() == btnPesquisar) {
            for (Jogo j : lista) {
                if (j.getTitulo().contains(txtTitulo.getText())) {
                    entityToBoundary(j);
                }
            }
        }
    }
}
