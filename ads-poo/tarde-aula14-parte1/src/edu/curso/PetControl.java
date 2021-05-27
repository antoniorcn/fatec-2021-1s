package edu.curso;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetControl {

    private static final String URL = "jdbc:mariadb://localhost:3306/petdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private ObservableList<Pet> lista = FXCollections.observableArrayList();
    private TableView<Pet> table = new TableView<>();

    private StringProperty nome = new SimpleStringProperty("");
    public StringProperty nomeProperty() {
        return nome;
    }

    private StringProperty raca = new SimpleStringProperty("");
    public StringProperty racaProperty() {
        return raca;
    }

    private DoubleProperty peso = new SimpleDoubleProperty(0.0);
    public DoubleProperty pesoProperty() {
        return peso;
    }

    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> nascimentoProperty() { return nascimento; }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PetControl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pet getEntity() {
        Pet p = new Pet();
        p.setNome(nome.get());
        p.setRaca(raca.get());
        p.setPeso(peso.get());
        p.setNascimento(nascimento.get());
        return p;
    }
    private void setEntity(Pet p) {
        if (p != null) {
            nome.set(p.getNome());
            raca.set(p.getRaca());
            peso.set(p.getPeso());
            nascimento.set(p.getNascimento());
        }
    }

    public void adicionar() {
        // lista.add( getEntity() );
        DateTimeFormatter fmtYMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//            String sql = String.format(Locale.ROOT,
//                    "INSERT INTO pet (nome, raca, peso, nascimento) VALUES ('%s', '%s', %.2f, '%s')",
//                    nome.get(), raca.get(), peso.get(), nascimento.get().format(fmtYMD));
//            System.out.println("SQL -> " + sql);

            String sql = "INSERT INTO pet (nome, raca, peso, nascimento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome.get());
            stmt.setString(2, raca.get());
            stmt.setDouble(3, peso.get());
            stmt.setDate(4, java.sql.Date.valueOf(nascimento.get()));
            stmt.executeUpdate();
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void pesquisarPets(String nome) {
        lista.clear();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM pet WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Pet p = new Pet();
                p.setNome(rs.getString("nome"));
                p.setRaca(rs.getString("raca"));
                p.setPeso(rs.getDouble("peso"));
                p.setNascimento(rs.getDate("nascimento").toLocalDate());

                lista.add(p);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisarPorNome() {
//        for (Pet p : lista) {
//            if (p.getNome().contains(nome.get())) {
//                setEntity(p);
//            }
//        }
        pesquisarPets(nome.get());
    }

    public void generateTable() {
        TableColumn<Pet, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Pet, String>("nome"));

        TableColumn<Pet, String> colRaca = new TableColumn<>("Raça");
        colRaca.setCellValueFactory(new PropertyValueFactory<Pet, String>("raca"));

        TableColumn<Pet, Double> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<Pet, Double>("peso"));

        TableColumn<Pet, String> colNascimento = new TableColumn<>("Nascimento");
        colNascimento.setCellValueFactory((item) -> {
            String txtData = item.getValue().getNascimento().format(formatter);
            return new ReadOnlyStringWrapper(txtData);
        });

        TableColumn<Pet, String> colAcoes = new TableColumn<>("Ações");

        Callback<TableColumn<Pet, String>, TableCell<Pet, String>> cellFactory = new
                Callback<TableColumn<Pet, String>, TableCell<Pet, String>>() {
                    @Override
                    public TableCell<Pet, String> call(TableColumn<Pet, String> param) {
                        TableCell<Pet, String> tableCell = new TableCell<Pet, String>() {
                            Button btn = new Button("Apagar");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                btn.setOnAction((e) -> {
                                    System.out.println(getIndex());
                                    lista.remove(getIndex());
                                    FXDialogs.show("Gestão de Pets",
                                            "Remoção de registro",
                                            "O registro " + getIndex() + " for removido com sucesso",
                                            Alert.AlertType.INFORMATION);
                                });
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return tableCell;
                    }
                };
        colAcoes.setCellFactory(cellFactory);

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setEntity(newValue);
        });

        table.getColumns().addAll(colNome, colRaca, colPeso, colNascimento, colAcoes);
        table.setItems(lista);
        pesquisarPets("");
    }

    public TableView<Pet> getTable() {
        return table;
    }
}
