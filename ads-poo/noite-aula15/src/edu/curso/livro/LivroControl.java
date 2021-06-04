package edu.curso.livro;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LivroControl {
    private ObservableList<Livro> livros = FXCollections.observableArrayList();
    private TableView<Livro> table = new TableView<>();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty titulo = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> lancamento = new SimpleObjectProperty<>(LocalDate.now());
    private IntegerProperty edicao = new SimpleIntegerProperty(1);
    private StringProperty autor = new SimpleStringProperty("");
    private StringProperty editora = new SimpleStringProperty("");
    private StringProperty isbn = new SimpleStringProperty("");
    private BooleanProperty disableSalvar = new SimpleBooleanProperty(true);
    private LivroDAO livroDAO = new LivroDAOImpl();

    public void setEntity(Livro l) {
        if (l != null) {
            id.set(l.getId());
            titulo.set(l.getTitulo());
            lancamento.set(l.getLancamento());
            edicao.set(l.getEdicao());
            autor.set(l.getAutor());
            editora.set(l.getEditora());
            isbn.set(l.getIsbn());
        }
    }

    public Livro getEntity() {
        Livro l = new Livro();
        l.setId(id.get());
        l.setTitulo(titulo.get());
        l.setLancamento(lancamento.get());
        l.setEdicao(edicao.get());
        l.setAutor(autor.get());
        l.setEditora(editora.get());
        l.setIsbn(isbn.get());
        return l;
    }

    public void adicionar() {
        Livro l = getEntity();
        livroDAO.adicionar(l);
        pesquisarInternamentePorTitulo("");
    }

    public void editar() {
        disableSalvarProperty().set(false);
    }

    public void atualizar() {
        livroDAO.atualizar(id.get(), getEntity());
        pesquisarInternamentePorTitulo("");
        disableSalvarProperty().set(true);
    }

    public void pesquisarInternamentePorTitulo(String titulo) {
        List<Livro> lista = livroDAO.pesquisarPorTitulo(titulo);
        livros.clear();
        livros.addAll(lista);
    }

    public void pesquisarPorTitulo() {
        pesquisarInternamentePorTitulo(titulo.get());
    }

    public void generatedTable() {
        pesquisarInternamentePorTitulo("");

        TableColumn<Livro, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Livro, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(new PropertyValueFactory<Livro, String>("titulo"));

        TableColumn<Livro, String> colAutor = new TableColumn<>("Autor");
        colAutor.setCellValueFactory(new PropertyValueFactory<Livro, String>("autor"));

        TableColumn<Livro, String> colAcoes = new TableColumn<>("Ações");

        Callback<TableColumn<Livro, String>, TableCell<Livro, String>> cellFactory =
                new Callback<TableColumn<Livro, String>, TableCell<Livro, String>>() {
                    public TableCell<Livro, String> call(final TableColumn<Livro, String> coluna) {
                        return new TableCell<Livro, String>() {
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    FlowPane fp = new FlowPane();
                                    final Button btnApagar = new Button("Apagar");
                                    final Button btnEditar = new Button("Editar");
                                    fp.getChildren().addAll(btnApagar, btnEditar);
                                    btnApagar.setOnAction((e) -> {
                                        // livros.remove(getIndex());
                                        Livro l = livros.get(getIndex());
                                        livroDAO.apagarPorId(l.getId());
                                        livros.remove(getIndex());

                                    });
                                    btnEditar.setOnAction((e) -> {
                                        Livro l = livros.get(getIndex());
                                        setEntity(l);
                                        editar();
                                    });
                                    setGraphic(fp);
                                    setText(null);
                                }
                            }
                        };
                    }
                };

        colAcoes.setCellFactory(cellFactory);

        table.getColumns().addAll(colId, colTitulo, colAutor, colAcoes);

        table.getSelectionModel().selectedItemProperty().addListener(
                        (obs, antigo, novo) -> {
                            setEntity(novo);
                        }
        );

        table.setItems(livros);
    }

    public long getId() {
        return id.get();
    }
    public LongProperty idProperty() {
        return id;
    }
    public String getTitulo() {
        return titulo.get();
    }
    public StringProperty tituloProperty() {
        return titulo;
    }
    public LocalDate getLancamento() {
        return lancamento.get();
    }
    public ObjectProperty<LocalDate> lancamentoProperty() {
        return lancamento;
    }
    public int getEdicao() {
        return edicao.get();
    }
    public IntegerProperty edicaoProperty() {
        return edicao;
    }
    public String getAutor() {
        return autor.get();
    }
    public StringProperty autorProperty() {
        return autor;
    }
    public String getEditora() {
        return editora.get();
    }
    public StringProperty editoraProperty() {
        return editora;
    }
    public String getIsbn() {
        return isbn.get();
    }
    public StringProperty isbnProperty() {
        return isbn;
    }

    public TableView<Livro> getTable() {
        return table;
    }

    public BooleanProperty disableSalvarProperty() {
        return disableSalvar;
    }
}
