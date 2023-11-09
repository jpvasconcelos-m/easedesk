package sistemachamados.model;

import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class UsuarioComum implements Usuario {




    String login;

    public UsuarioComum(String login) {
        this.login = login;
    }


    void criarChamado(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite a descricão do chamado: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a prioridade de 1 a 3:");
        int prioridade = sc.nextInt();
        fila.add(new Chamado(descricao,prioridade,this));


    }


    public String getLogin() {
        return login;
    }


    @Override
    public void capturarChamado() {

        System.out.println("Permissão negada!");

    }
}
