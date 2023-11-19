package sistemachamados.BancoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdicionarUsuario {

    public void adicionarUsuario () throws SQLException{
        HashSenhas hs = new HashSenhas();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        System.out.println("Digite a senha: ");
        String senha = hs.hashPassword(sc.nextLine());
        System.out.println();
        System.out.println("O usuário é administrador (true/false) ?");
        Boolean isAdmin = sc.nextBoolean();

        Connection conexao = FabricaConexao.getConexao();


        String sql = " INSERT INTO usuarios (nome,email,senha,isadmin) VALUES (?,?,?,?)";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1,nome);
        pstmt.setString(2,email);
        pstmt.setString(3,senha);
        pstmt.setBoolean(4,isAdmin);

        pstmt.executeUpdate();

        System.out.println("Dados inseridos com sucesso!");







    }

    public static void main(String[] args)  throws SQLException{
        new AdicionarUsuario().adicionarUsuario();
    }


}
