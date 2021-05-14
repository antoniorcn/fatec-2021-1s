package edu.curso.livro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtISBN = new TextField();
    private TextField txtTitulo = new TextField();
    private TextField txtEdicao = new TextField();
    private TextField txtLancamento = new TextField();
    private TextField txtAutor = new TextField();
    private TextField txtEditora = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private LivroControl control = new LivroControl();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 600, 400);

        gp.add(new Label("Id"), 0, 0);
        gp.add(txtId,1, 0);
        gp.add(new Label("ISBN"), 0, 1);
        gp.add(txtISBN,1, 1);
        gp.add(new Label("Titulo"), 0, 2);
        gp.add(txtTitulo,1, 2);
        gp.add(new Label("Edição"), 0, 3);
        gp.add(txtEdicao,1, 3);
        gp.add(new Label("Lançamento"), 0, 4);
        gp.add(txtLancamento,1, 4);
        gp.add(new Label("Autor"), 0, 5);
        gp.add(txtAutor,1, 5);
        gp.add(new Label("Editora"), 0, 6);
        gp.add(txtEditora,1, 6);
        gp.add(btnAdicionar, 0, 7);
        gp.add(btnPesquisar, 1, 7);

        btnAdicionar.setOnAction((e)->{
//                    Livro l = boundaryToEntity();
//                    control.adicionar(l);
                    control.adicionar(boundaryToEntity());
                    this.entityToBoundary(new Livro());
                });

        btnPesquisar.setOnAction((e)->{
            Livro l = control.pesquisarPorTitulo(txtTitulo.getText());
            this.entityToBoundary(l);
        });

        stage.setScene(scn);
        stage.setTitle("Gestão de Livros");
        stage.show();
    }

    public Livro boundaryToEntity() {
        Livro l = new Livro();
        l.setTitulo(txtTitulo.getText());
        l.setAutor(txtAutor.getText());
        l.setEditora(txtEditora.getText());
        l.setIsbn(txtISBN.getText());
        try {
            l.setId(Long.parseLong(txtId.getText()));
            l.setEdicao(Integer.parseInt(txtEdicao.getText()));
            l.setLancamento(LocalDate.parse(txtLancamento.getText(), dtf) );
        } catch(Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public void entityToBoundary(Livro l) {
        if (l != null) {
            txtId.setText(String.valueOf(l.getId()));
            txtTitulo.setText(l.getTitulo());
            txtEditora.setText(l.getEditora());
            txtAutor.setText(l.getAutor());
            txtISBN.setText(l.getIsbn());
            txtEdicao.setText(String.valueOf(l.getEdicao()));
            txtLancamento.setText(l.getLancamento().format(dtf));
        }
    }

    public static void main(String[] args) {
        Application.launch(LivroBoundary.class, args);
    }
}
