package com.example.usuario;

import java.util.Scanner;

public class Usuario {
    
    private int id;
    private String nome;
    private String senha;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getSenha() {
        return senha;
    }
    
    //MÉTODO CRIAR USUARIO
    public void criarUsuario(Scanner scanner) {

        //Scanner scanner = new Scanner(System.in);

        System.out.println("ID do usuário: ");
        this.id = scanner.nextInt();

        scanner.nextLine();

        System.out.println("NOME de usuário: ");
        this.nome = scanner.nextLine();

        System.out.println("SENHA de usuário: ");
        this.senha = scanner.nextLine();
        
    }
}
