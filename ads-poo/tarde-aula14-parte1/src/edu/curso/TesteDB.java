package edu.curso;

import java.sql.*;

public class TesteDB {
    public static final String URL = "jdbc:mariadb://localhost:3306/petdb";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static void main(String[] args) {
        System.out.println("Teste de Banco de Dados");

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Classe MariadbDriver carregada");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado no banco de dados");

            String sql = "INSERT INTO pet (nome, raca, peso, nascimento) VALUES " +
                    "('Thor', 'Pastor Alemão', 22.4, '2015-10-20')";

            PreparedStatement psmt = con.prepareStatement(sql);
            // psmt.executeUpdate();
            System.out.println("Pet cadastrado com sucesso");

            psmt = con.prepareStatement("SELECT * FROM pet");
            ResultSet rs = psmt.executeQuery();

            while(rs.next()) {
                System.out.println("Raca: ==>" + rs.getString("raca"));
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
