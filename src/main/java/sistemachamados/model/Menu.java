package sistemachamados.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class Menu {

    static Scanner sc = new Scanner(System.in);





    public static void main(String[] args) {



        Usuario usuario = (Usuario) receberLogin();


        mostrarOpcoes();

        int opcao = 99;
        while(opcao != 0) {
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
                criarChamado((Usuario) usuario);
                System.out.println("Chamado Criado!\n");
                mostrarOpcoes();
            case 2:
                if (fila.isEmpty()){
                    mostrarOpcoes();
                    System.out.println("Não há nenhum chamado na fila.");
                    continue;

                }
                else
                verFila();
                continue;
            case 3:

                usuario.capturarChamado();
                continue;
            case 4:
                usuario =  (Usuario) receberLogin();
                mostrarOpcoes();
                continue;




            default: break;
        }


        }


    }

    private static Object receberLogin() {
        System.out.println("Entre seu usuário: ");
        String usuario = sc.nextLine();
        if (usuario.contains("admin")){
            return new UsuarioTI(usuario);
        }
        else {
            return new UsuarioComum(usuario);
        }






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

        new Chamado(descricao,prioridade, (UsuarioComum) usuario);


    }

    static void verFila(){
      fila.stream().forEach(chamado -> {
          System.out.println(chamado.toString());
      });
    }




}
