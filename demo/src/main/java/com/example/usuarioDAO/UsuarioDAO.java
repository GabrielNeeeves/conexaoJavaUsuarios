package com.example.usuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.usuario.Usuario;

public class UsuarioDAO {
    
    //MÉTODO INSERIR DADOS
    public static void inserirDados(Connection conn, Usuario user) {

        try (PreparedStatement query = conn.prepareStatement("INSERT INTO USUARIOS (ID, NOME, SENHA) VALUES (?, ?, ?)")) {

            query.setInt(1, user.getId());
            query.setString(2, user.getNome());
            query.setString(3, user.getSenha());
            
            int linhasAfetadas = query.executeUpdate();

            System.out.println("Linhas inseridas: "+linhasAfetadas);
            
        } catch (SQLException e) {
            System.out.println("Erro de inserção. "+e.getMessage());
        }
    }

    //MÉTODO CONSULTA DADOS
    public static void consultaDados(Connection conn) {

        try (PreparedStatement stm = conn.prepareStatement("SELECT * FROM USUARIOS")) {

            ResultSet rs = stm.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                String senha = rs.getString("SENHA");

                System.out.println("ID: "+id+", NOME: "+nome+", SENHA: "+senha);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erro de consulta. "+e.getMessage());
        }
    }

    //MÉTODO EXCLUIR DADOS
    public static void excluirDados(Connection conn, Scanner scanner) {

        String sql = "DELETE FROM USUARIOS WHERE ID = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, scanner.nextInt());

            //stm.executeUpdate();
            //stm.close();

            int linhasAfetadas = stm.executeUpdate();
            System.out.println("Linhas excluídas: "+linhasAfetadas);
            stm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro de exclusão. "+e.getMessage());
        }
    }
}
