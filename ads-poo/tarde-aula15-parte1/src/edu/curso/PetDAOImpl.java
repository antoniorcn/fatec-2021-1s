package edu.curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/petdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public PetDAOImpl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adicionar(Pet p) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO pet (nome, raca, peso, nascimento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRaca());
            stmt.setDouble(3, p.getPeso());
            stmt.setDate(4, java.sql.Date.valueOf(p.getNascimento()));
            stmt.executeUpdate();
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pet> pesquisarPorNome(String nome) {
        List<Pet> lista = new ArrayList<>();
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
        return lista;
    }

    @Override
    public void remover(long id) {
    }

}
