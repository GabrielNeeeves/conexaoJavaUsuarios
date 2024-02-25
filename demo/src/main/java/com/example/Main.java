package com.example;

import java.util.Scanner;
import com.example.conexao.Conexao;
import com.example.usuario.Usuario;
import com.example.usuarioDAO.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Conexao.conectar();

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Consultar tabela");
            System.out.println("3. Excluir Usuario");
            System.out.println("4. Sair");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    Usuario user = new Usuario();
                    user.criarUsuario(scanner);

                    UsuarioDAO.inserirDados(Conexao.conexao, user);
                    break;
                case 2:
                    //CHAMAR MÉTODO CONSULTA
                    UsuarioDAO.consultaDados(Conexao.conexao);
                    break;
                case 3:
                    System.out.println("ID para exlcuir: ");
                    //CHAMAR MÉTODO EXCLUSÃO
                    UsuarioDAO.excluirDados(Conexao.conexao, scanner);
                    break;
                case 4:
                    System.out.println("Saiu.");
                    return;
                default:
                    System.out.println("Valor inválido");
            }
        }
    }
}