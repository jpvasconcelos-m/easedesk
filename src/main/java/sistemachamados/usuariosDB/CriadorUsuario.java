package sistemachamados.usuariosDB;

import sistemachamados.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class CriadorUsuario {
    Usuario novoUsuario;

    public Usuario adicionarUsuario () throws SQLException{
        HashSenhas hs = new HashSenhas();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        System.out.println("Digite a senha: ");
        String salt = hs.generateSalt();
        String hash = hs.hashPassword(salt + sc.nextLine());
        System.out.println();
        System.out.println("O usuário é administrador (true/false) ?");
        Boolean isAdmin = sc.nextBoolean();
        Connection conexao = FabricaConexao.getConexao();


        String sql = " INSERT INTO usuarios (nome,email,salt,hash,isadmin) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1,nome);
        pstmt.setString(2,email);
        pstmt.setString(3,salt);
        pstmt.setString(4,hash);
        pstmt.setBoolean(5,isAdmin);

        pstmt.executeUpdate();

        System.out.println("Dados inseridos com sucesso!");

        return novoUsuario;







    }

    public static void main(String[] args)  throws SQLException{
        new CriadorUsuario().adicionarUsuario();

    }


}
