package sistemachamados.model;

import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class UsuarioTI extends Usuario {


    public UsuarioTI(String login) {
        super(login);
    }

    void capturarChamado(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Digite o índice do chamado que deseja capturar: ");
        int indice =  sc.nextInt();
        Chamado chamado = fila.get(indice);
        chamado.setUsuarioResponsavel(this);

        System.out.printf("\nO usuario responsável pelo chamado '%s' é : %s",chamado.getDescricao(),chamado.getUsuarioResponsavel().getLogin());








    }






}
