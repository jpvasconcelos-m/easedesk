package sistemachamados.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

class Menu {

    static private Scanner sc = new Scanner(System.in);
    static private GerenciadorLogin gl = new GerenciadorLogin();





    public static void main(String[] args) {



        Usuario usuario = gl.iniciarGerenciadorLogin();


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
                criarChamado(usuario);
                System.out.println("Chamado Criado!");
                mostrarOpcoes();
                continue;
            case 2:
                usuario.capturarChamado();
                continue;
            case 3:
                if (fila.isEmpty()){
                    mostrarOpcoes();
                    System.out.println("Não há nenhum chamado na fila.");
                    continue;

                }
                else
                    verFila();
                    continue;


            case 4: usuario.finalizarChamado();
                    mostrarOpcoes();
                    continue;

            case 5: removerChamado();
                    continue;


            default: break;
        }


        }


    sc.close();
    }



    static void mostrarOpcoes(){
        System.out.println("""
                1 - Criar Chamado;
                2 - Capturar Chamado;
                3 - Ver Fila de Chamados;
                4 - Finalizar Chamado;
                0 - Sair;
                """);




    }

    static void criarChamado(Usuario usuario){
        String prioridade = "0";


        System.out.println("Digite a descrição do chamado: ");
        String descricao = sc.nextLine();

        while(!((prioridade.equals("1") || prioridade.equals("2"))||prioridade.equals("3"))) {
            System.out.println("Defina a prioridade (1 a 3)");
            prioridade = sc.nextLine();


        }

        new Chamado(descricao, Integer.parseInt(prioridade), (Usuario) usuario).setStatus(Status.ABERTO);




            }







    static void verFila(){

      fila.stream().forEach(chamado -> {
          System.out.println(chamado.toString());
      });
    }






    static void removerChamado(){
        System.out.println("Escolha o ID de um chamado que deseja remover da fila: ");
        verFila();
        int id  = sc.nextInt();
        fila.remove(id);
        verFila();
        mostrarOpcoes();
    }




}
