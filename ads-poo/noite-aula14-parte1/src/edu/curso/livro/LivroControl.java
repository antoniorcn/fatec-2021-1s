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

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroControl {
    private static final String URL = "jdbc:mariadb://localhost:3306/livrodb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private ObservableList<Livro> livros = FXCollections.observableArrayList();
    private TableView<Livro> table = new TableView<>();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty titulo = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> lancamento = new SimpleObjectProperty<>(LocalDate.now());
    private IntegerProperty edicao = new SimpleIntegerProperty(1);
    private StringProperty autor = new SimpleStringProperty("");
    private StringProperty editora = new SimpleStringProperty("");
    private StringProperty isbn = new SimpleStringProperty("");

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
//        Livro l = getEntity();
//        livros.add(l);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            String strLancamento = lancamento.get().format(dtf);
//            String sql = String.format("INSERT INTO livro " +
//                    "(titulo, lancamento, edicao, " +
//                    "autor, editora, isbn) VALUES " +
//                    "('%s', '%s', %d, " +
//                    "'%s', '%s', '%s')", titulo.get(), strLancamento, edicao.get(),
//                    autor.get(), editora.get(), isbn.get());
//            System.out.println("SQL ==> " + sql);
            String sql = "INSERT INTO livro " +
                    "(titulo, lancamento, edicao, " +
                    "autor, editora, isbn) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, titulo.get());
            stmt.setDate(2, java.sql.Date.valueOf(lancamento.get()));
            stmt.setInt(3, edicao.get());
            stmt.setString(4, autor.get());
            stmt.setString(5, editora.get());
            stmt.setString(6, isbn.get());
            int i = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisarPorTitulo() {
//        for (Livro l : livros) {
//            if (l.getTitulo().contains(titulo.get())) {
//                this.setEntity(l);
//            }
//        }
        livros.clear();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM livro WHERE titulo LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + titulo.get() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setIsbn(rs.getString("isbn"));
                l.setEditora(rs.getString("editora"));
                l.setEdicao(rs.getInt("edicao"));
                l.setAutor(rs.getString("autor"));
                l.setLancamento(rs.getDate("lancamento").toLocalDate());
                livros.add(l);
//                System.out.println(rs.getString("titulo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generatedTable() {
        TableColumn<Livro, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Livro, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(new PropertyValueFactory<Livro, String>("titulo"));

        TableColumn<Livro, String> colAutor = new TableColumn<>("Autor");
        colAutor.setCellValueFactory(new PropertyValueFactory<Livro, String>("autor"));

        TableColumn<Livro, String> colAcoes = new TableColumn<>("Ações");

//        Callback<TableColumn<Livro, String>, TableCell<Livro, String>> cellFactoryLambda = col ->
//            new TableCell<Livro, String>() {
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                        setText(null);
//                    } else {
//                        final Button btn = new Button("Apagar");
//                        btn.setOnAction((e) -> {
//                            System.out.println(getIndex());
//                            livros.remove(getIndex());
//                        });
//                        setGraphic(btn);
//                        setText(null);
//                    }
//                }
//        };

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
                                        livros.remove(getIndex());
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
}
