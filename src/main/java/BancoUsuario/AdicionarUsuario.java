package BancoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdicionarUsuario {

    public static void main(String[] args) throws SQLException {
        HashSenhas hs = new HashSenhas();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        System.out.println("Digite o login: ");
        String login = sc.nextLine();
        System.out.println("Digite a senha: ");
        String senha = hs.hashPassword(sc.nextLine());
        System.out.println("O hash da senha é " + senha);

        Connection conexao = FabricaConexao.getConexao();


        String sql = " INSERT INTO usuarios (nome,email,login,senha) VALUES (?,?,?,?)";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1,nome);
        pstmt.setString(2,email);
        pstmt.setString(3,login);
        pstmt.setString(4,senha);

        pstmt.executeUpdate();

        System.out.println("Dados inseridos com sucesso!");






    }


}
