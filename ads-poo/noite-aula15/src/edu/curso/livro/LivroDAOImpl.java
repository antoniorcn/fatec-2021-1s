package edu.curso.livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    private static final String URL = "jdbc:mariadb://localhost:3306/livrodb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    @Override
    public void adicionar(Livro l) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO livro " +
                    "(titulo, lancamento, edicao, " +
                    "autor, editora, isbn) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, l.getTitulo());
            stmt.setDate(2, java.sql.Date.valueOf(l.getLancamento()));
            stmt.setInt(3, l.getEdicao());
            stmt.setString(4, l.getAutor());
            stmt.setString(5, l.getEditora());
            stmt.setString(6, l.getIsbn());
            int i = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> lista = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM livro WHERE titulo LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + titulo + "%");
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
                lista.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
