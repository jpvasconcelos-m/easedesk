package sistemachamados.usuariosDB;

import org.springframework.security.crypto.password.PasswordEncoder;
import sistemachamados.model.Usuario;
import sistemachamados.model.UsuarioTI;

import java.sql.*;

public class VerificarUsuario {
    static Connection conexao = FabricaConexao.getConexao();
    static HashSenhas hs = new HashSenhas();

   public void usuarioJaExiste (Usuario usuario) throws SQLException{


       String sql = "SELECT * FROM usuarios WHERE email = ?";
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setString(1,usuario.getEmail());
      ResultSet resultSet = pstmt.executeQuery();

      while(resultSet.next()){
          int id = resultSet.getInt("id");
          String nome = resultSet.getString("nome");
          String email = resultSet.getString("email");
          String senha = resultSet.getString("senha");
          Boolean isAdmin = resultSet.getBoolean("isadmin");

          System.out.println("ID: "+ id + ", Nome: " + nome + ", Email: " + email + ", Administrador : " + (isAdmin? "Sim":"Nao"));


      }



   }

   public boolean autenticacaoUsuario(String email, String senha){
       String sql = "SELECT * FROM usuarios WHERE email = ?";
       try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
           pstmt.setString(1, email);




           ResultSet resultSet = pstmt.executeQuery();
           if (resultSet.next() ){
               if(hs.checkPassword(senha,resultSet.getString("senha"))){
                   System.out.println("Sucesso");
               }
               else {
                   System.out.println("Falha");
               }
           }
           else {
               System.out.println("Email e/ou senha incorretos.");
               return false;
           }

       }catch (SQLException e){
           e.printStackTrace();
       }

       return false;
   }

    public static void main(String[] args) throws SQLException {
        System.out.println(hs.checkPassword("pedro132",hs.hashPassword("pedro132") ));

    }



}
