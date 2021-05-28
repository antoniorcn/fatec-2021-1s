package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDB {

    public static final String URL = "jdbc:mariadb://localhost:3306/livrodb";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {
        System.out.println("Teste de Banco de dados");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado na memoria");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado no banco de dados");
            String sql = "INSERT INTO livro " +
                    "(titulo, lancamento, edicao, " +
                    "autor, editora, isbn) VALUES " +
                    "('Clean Code', '2012-07-10', 2, " +
                    "'ROBERT MARTIN', 'Moderna', '22222222222')";
            PreparedStatement stmt = con.prepareStatement(sql);
            int i = stmt.executeUpdate();
            con.close();
            System.out.println("Linhas afetadas ==> " + i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
