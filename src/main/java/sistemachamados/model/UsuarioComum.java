package sistemachamados.model;

import sistemachamados.usuariosDB.HashSenhas;

import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class UsuarioComum implements Usuario {



    String nome;
    String email;
    String senha;
    Boolean isAdmin = false;

    public UsuarioComum(String email,String senha) {
        this.email = email;
        this.senha = new HashSenhas().hashPassword(senha);
    }


    void criarChamado(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite a descricão do chamado: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a prioridade de 1 a 3:");
        int prioridade = sc.nextInt();
        fila.add(new Chamado(descricao,prioridade,this));


    }


    public String getEmail() {
        return email;
    }

    @Override
    public String getHashSenha() {
        return this.senha;
    }


    @Override
    public void capturarChamado() {

        System.out.println("Permissão negada!");

    }

    @Override
    public void finalizarChamado() {
        System.out.println("Permissão negada!");
    }
}
