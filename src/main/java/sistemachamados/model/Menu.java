package sistemachamados.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class Menu {

    static Scanner sc = new Scanner(System.in);





    public static void main(String[] args) {



        Usuario usuario =  receberLogin();


        mostrarOpcoes();

        int opcao = 0;
        while(opcao != 4) {
            try {
                opcao = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e ){
                e.printStackTrace();
                mostrarOpcoes();
                System.out.println("Digite um valor válido !!!");

               sc.nextLine();

                continue;


            }
        switch(opcao){
            case 1:
                criarChamado(usuario);
                System.out.println("Chamado Criado!\n");
                mostrarOpcoes();
            case 2:
                if (fila.isEmpty()){
                    System.out.println("Não há nenhum chamado na fila.\n");
                    mostrarOpcoes();
                }
                else
                verFila();

            default: break;
        }


        }


    }

    private static Usuario receberLogin() {

        System.out.println("Entre seu usuário: ");
        String usuario = sc.nextLine();


        return new Usuario(usuario);
    }

    static void mostrarOpcoes(){
        System.out.println("1 - Criar Chamado\n2 - Ver fila de Chamados\n3 - Capturar Chamado\n4 - Sair");





    }

    static void criarChamado(Usuario usuario){



        System.out.println("Digite a descrição do chamado: ");
        String descricao = sc.nextLine();
        System.out.println("Defina a prioridade (1 a 3)");
        int prioridade = sc.nextInt();
        sc.nextLine();

        new Chamado(descricao,prioridade,usuario);


    }

    static void verFila(){
      fila.stream().forEach(chamado -> {
          System.out.printf("ID %d; Descrição: '%s' ; Usuario criador: %s\n",chamado.id,chamado.getDescricao(),chamado.usuarioCriador.getLogin());
      });
    }

    static void capturarChamado(UsuarioTI usuarioCapturador){

        usuarioCapturador.capturarChamado();

    }


}
