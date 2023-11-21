package sistemachamados.model;

import sistemachamados.usuariosDB.CriadorUsuario;
import sistemachamados.usuariosDB.VerificarUsuario;

import java.sql.SQLException;
import java.util.Scanner;

import static sistemachamados.model.FilaChamados.fila;

public class Usuario {


    Scanner sc = new Scanner(System.in);
    String temp;



     String email;

    Boolean isAdmin;

    CriadorUsuario criadorUsuario = new CriadorUsuario();
    GerenciadorLogin gl = new GerenciadorLogin();


    public void setEmail(String email) {
        this.email = email;

    }



    public Usuario(String email){
        VerificarUsuario vu = new VerificarUsuario();
        this.email = email;
        try {
            this.isAdmin = vu.usuarioisAdmin(email);
           if(vu.usuarioExiste(email) == false){
               gl.perguntarCadastro();
           }

        }catch (SQLException e){
            e.printStackTrace();


        }

    }






    void criarChamado(){



        System.out.println("Digite a descricão do chamado: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a prioridade de 1 a 3:");
        int prioridade = sc.nextInt();
        fila.add(new Chamado(descricao,prioridade,this));


    }


    public String getEmail() {
        return this.email;
    }






    public void capturarChamado() {
        if (isAdmin == false) {
            System.out.println("Permissão negada!");
        }
        else if (isAdmin == true){
            Menu.verFila();

            System.out.println("Digite o índice do chamado que deseja capturar: ");
            int indice = -9;
            while (indice > fila.size()|| indice < 0){

            try {
                indice =  sc.nextInt();
                sc.nextLine();
                Chamado chamado = fila.get(indice);
                chamado.setUsuarioResponsavel(this);
                chamado.setStatus(Status.CAPTURADO);
                System.out.printf("\nO usuario responsável pelo chamado ID: %d, DESCRIÇÃO: '%s' é : %s\n",chamado.id,chamado.getDescricao(),chamado.getUsuarioResponsavel().getEmail());
                Menu.mostrarOpcoes();
                break;
            }catch (IndexOutOfBoundsException e){
                Menu.verFila();
                System.out.println("Digite um índice de chamado válido válido!");

                continue;

            }}




        }


    }


    public void finalizarChamado() {
        if(isAdmin == false) {
            System.out.println("Permissão negada!");
        }
        else if(isAdmin == true){
            System.out.println("Escolha o ID de um chamado que deseja finalizar: ");
            int id = sc.nextInt();
            sc.nextLine();


            System.out.println("Digite uma solução: ");
            String solucao = sc.nextLine();
            fila.get(id).setSolucao(solucao);
            fila.get(id).setStatus(Status.CONCLUIDO);
            Menu.mostrarOpcoes();
        }

    }
}
