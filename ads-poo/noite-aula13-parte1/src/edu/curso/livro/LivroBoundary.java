package edu.curso.livro;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;
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
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene(panePrincipal, 600, 400);

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

        control.generatedTable();
        panePrincipal.setTop(gp);
        panePrincipal.setCenter(control.getTable());

        btnAdicionar.setOnAction((e)->{control.adicionar();});
        btnPesquisar.setOnAction((e)->{control.pesquisarPorTitulo();});

        StringConverter longToStringConverter = new LongStringConverter();
        StringConverter integerToStringConverter = new IntegerStringConverter();
        StringConverter localDateToStringConverter = new LocalDateStringConverter();

        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtTitulo.textProperty(), control.tituloProperty());
        Bindings.bindBidirectional(txtLancamento.textProperty(), control.lancamentoProperty(), localDateToStringConverter);
        Bindings.bindBidirectional(txtEdicao.textProperty(), control.edicaoProperty(), integerToStringConverter);
        Bindings.bindBidirectional(txtAutor.textProperty(), control.autorProperty());
        Bindings.bindBidirectional(txtEditora.textProperty(), control.editoraProperty());
        Bindings.bindBidirectional(txtISBN.textProperty(), control.isbnProperty());

        stage.setScene(scn);
        stage.setTitle("Gestão de Livros");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(LivroBoundary.class, args);
    }
}
