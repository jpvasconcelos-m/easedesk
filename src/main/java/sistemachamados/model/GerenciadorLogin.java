package sistemachamados.model;

import sistemachamados.usuariosDB.CriadorUsuario;
import sistemachamados.usuariosDB.VerificarUsuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorLogin {

    String opcoesLogin = """
            1 - Entrar;
            2 - Cadastrar;
            3 - Sair;
            """;
     static ArrayList<Integer> valoresValidos = new ArrayList<>();

     static {valoresValidos.add(1);valoresValidos.add(2);valoresValidos.add(3);}
    Scanner sc = new Scanner(System.in);




    public Usuario iniciarGerenciadorLogin(){
        Scanner sc = new Scanner(System.in);

        int opcao = 99;
        while(opcao != 3) {
            try {
                System.out.println(opcoesLogin);
                opcao = sc.nextInt();
                sc.nextLine();
                if(!valoresValidos.contains(opcao)){
                    throw new InputMismatchException();

                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println(opcoesLogin);
                System.out.println("Digite um valor válido !!!");

                sc.nextLine();

                continue;


            }
            switch (opcao) {
                case 1:
                    System.out.println("\033[4mLogin:\033[0m");
                    System.out.println("Digite seu login e senha:");
                    return entrar(sc.nextLine(), sc.nextLine());

                case 2:
                    System.out.println("\033[4mCadastro:\033[0m");
                    cadastro();
                    continue;



            }
        }
        sc.close();
        return null;
    }


    public Usuario cadastro(){
        CriadorUsuario criadorUsuario = new CriadorUsuario();
        try {
          return criadorUsuario.adicionarUsuario();

        }
        catch (SQLException e){
            System.out.println("Falha ao adicionar usuário!");
            e.printStackTrace();
        }
        return null;
    }

    public Usuario entrar(String login, String senha){
        VerificarUsuario vu = new VerificarUsuario();
        try {
            vu.autenticacaoUsuario(login, senha);
        }catch (SQLException e ){
            System.out.println("Falha ao entrar com usuário!");
        }
        return new Usuario(login);

    }
    public void encerrar(){
        System.out.println("Tchau!");
        System.exit(0);
    }

    public static void main(String[] args) {
        GerenciadorLogin gl = new GerenciadorLogin();
      gl.entrar("@.@aaaaaaaaaaaaaaaaa","1234");
    }

    public Usuario perguntarCadastro(){
        System.out.println("Deseja fazer novo cadastro? (s/n)");
        String simNao = sc.nextLine();
        if(simNao.equalsIgnoreCase("s")){
           return this.cadastro();
        }
        else {
            System.out.println("Saindo...");
            System.exit(0);
            return null;
        }

    }




}
