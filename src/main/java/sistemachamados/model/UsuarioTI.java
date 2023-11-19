package sistemachamados.model;
import sistemachamados.usuariosDB.HashSenhas;

import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class UsuarioTI extends UsuarioComum {

   static  Scanner sc= new Scanner(System.in);

    Boolean isAdmin = true;



    public UsuarioTI(String email, String senha) {
        super(email,senha);


    }

    public void capturarChamado(){

        Menu.verFila();

        System.out.println("Digite o índice do chamado que deseja capturar: ");
        int indice =  sc.nextInt();
        Chamado chamado = fila.get(indice);
        chamado.setUsuarioResponsavel(this);
        chamado.setStatus(Status.CAPTURADO);

        System.out.printf("\nO usuario responsável pelo chamado ID: %d, DESCRIÇÃO: '%s' é : %s\n",chamado.id,chamado.getDescricao(),chamado.getUsuarioResponsavel().getEmail());
        Menu.mostrarOpcoes();



    }

    public  void finalizarChamado(){

        System.out.println("Escolha o ID de um chamado que deseja finalizar: ");
        int id = sc.nextInt();
        sc.nextLine();


        System.out.println("Digite uma solução: ");
        String solucao = sc.nextLine();
        fila.get(id).setSolucao(solucao);
        fila.get(id).setStatus(Status.CONCLUIDO);
        Menu.mostrarOpcoes();


    }

    public void consultarChamadosCapturadosPorMim(){
        System.out.println((fila.stream().filter(chamado -> chamado.usuarioResponsavel == this && chamado.status == Status.CAPTURADO)).toString());
    }





}
