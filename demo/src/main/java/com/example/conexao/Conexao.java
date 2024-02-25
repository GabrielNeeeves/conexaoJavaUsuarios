package com.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "rootadmin";

    public static Connection conexao;

    //MÉTODO CRIAR CONECTAR AO BANCO
    public static Connection conectar() {

        try {
            if(conexao == null) {
            
                conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                System.out.println("banco conectado");
                return conexao;
            } else {
                return conexao;
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão: "+e.getMessage());
            return conexao;
            }
    }
    
}
