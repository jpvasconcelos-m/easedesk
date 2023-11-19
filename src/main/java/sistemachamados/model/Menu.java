package sistemachamados.model;

import sistemachamados.BaseUsuario.AdicionarUsuario;

import java.sql.SQLException;
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
                criarChamado(usuario);
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

            case 4: usuario.finalizarChamado();
                    mostrarOpcoes();
                    continue;

            case 5: removerChamado();
                    continue;


            case 6:
                usuario =  (Usuario) receberLogin();
                mostrarOpcoes();
                continue;
            case 7:
               try {
                   new AdicionarUsuario().adicionarUsuario();
               }catch (SQLException e){
                   System.out.println("Falha ao adicionar usuário");
                   throw new RuntimeException(e);

               }
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
        System.out.println("1 - Criar Chamado\n2 - Ver fila de Chamados\n3 - Capturar Chamado\n4 - Finalizar Chamado\n5 - Remover da Fila\n6 - Trocar Usuário ");





    }

    static void criarChamado(Usuario usuario){
        String prioridade = "0";


        System.out.println("Digite a descrição do chamado: ");
        String descricao = sc.nextLine();

        while(!((prioridade.equals("1") || prioridade.equals("2"))||prioridade.equals("3"))) {
            System.out.println("Defina a prioridade (1 a 3)");
            prioridade = sc.nextLine();

        }

        new Chamado(descricao, Integer.parseInt(prioridade), (UsuarioComum) usuario).setStatus(Status.ABERTO);




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
