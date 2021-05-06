package edu.curso.por.dominio.jogo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class JogoBoundary extends Application
                            implements EventHandler<ActionEvent> {
    private TextField txtId = new TextField("");
    private TextField txtTitulo = new TextField("");
    private TextField txtGenero = new TextField("");
    private TextField txtClassificacao = new TextField("");
    private TextField txtStudio = new TextField("");
    private TextField txtLancamento = new TextField("");
    private TextField txtMidia = new TextField("");
    private TextArea txtDescricao = new TextArea("");

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Scene scn = new Scene(grid, 600, 400);
        grid.setStyle("-fx-margin: 30px");

        grid.add(new Label("Id: "), 0, 0);
        grid.add(txtId, 1, 0);
        grid.add(new Label("Titulo: "), 0, 1);
        grid.add(txtTitulo, 1, 1);
        grid.add(new Label("Genero: "), 0, 2);
        grid.add(txtGenero, 1, 2);
        grid.add(new Label("Classificacao: "), 0, 3);
        grid.add(txtClassificacao, 1, 3);
        grid.add(new Label("Studio: "), 0, 4);
        grid.add(txtStudio, 1, 4);
        grid.add(new Label("Lancamento: "), 0, 5);
        grid.add(txtLancamento, 1, 5);
        grid.add(new Label("Midia: "), 0, 6);
        grid.add(txtMidia, 1, 6);
        grid.add(new Label("Descricao: "), 0, 7);
        grid.add(txtDescricao, 1, 7);
        grid.add(btnAdicionar, 0, 8);
        grid.add(btnPesquisar, 1, 8);

        btnAdicionar.addEventFilter(ActionEvent.ACTION, this);
        btnPesquisar.addEventFilter(ActionEvent.ACTION, this);

        stage.setScene(scn);
        stage.setTitle("Gestão de Jogos");
        stage.show();
    }

    public Jogo boundaryToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Jogo e = new Jogo();
        try {
            e.setTitulo(txtTitulo.getText());
            e.setGenero(txtGenero.getText());
            e.setEstudio(txtStudio.getText());
            e.setMidia(txtMidia.getText());
            e.setDescricao(txtDescricao.getText());

            e.setId(Long.parseLong(txtId.getText()));
            e.setClassificacao(Integer.parseInt(txtClassificacao.getText()));
            LocalDate d = LocalDate.parse(txtLancamento.getText(), formatter);
            e.setLancamento(d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnAdicionar) {
            System.out.println("Botão Adicionar foi pressionado");
        } else if (event.getSource() == btnPesquisar) {
            System.out.println("Botão Pesquisar foi pressionado");
        }
    }
}

