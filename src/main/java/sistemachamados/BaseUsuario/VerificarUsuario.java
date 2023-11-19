package sistemachamados.BaseUsuario;

import sistemachamados.model.Usuario;

import java.sql.*;

public class VerificarUsuario {


   public void usuarioJaExiste (Usuario usuario) throws SQLException{

       Connection conexao = FabricaConexao.getConexao();
       String sql = "SELECT * FROM usuarios WHERE login = ?";
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setString(1,usuario.getLogin());
      ResultSet resultSet = pstmt.executeQuery();

      while(resultSet.next()){
          int id = resultSet.getInt("id");
          String nome = resultSet.getString("nome");
          String email = resultSet.getString("email");
          String senha = resultSet.getString("senha");
          Boolean isAdmin = resultSet.getBoolean("isadmin");

          System.out.println("ID: "+ id + ", Nome: " + nome + ", Email: " + email);


      }






   }



}
