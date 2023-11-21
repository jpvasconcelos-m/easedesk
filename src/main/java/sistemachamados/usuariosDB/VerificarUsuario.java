package sistemachamados.usuariosDB;

import sistemachamados.model.GerenciadorLogin;
import sistemachamados.model.Usuario;

import java.sql.*;

public class VerificarUsuario {
    static Connection conexao = FabricaConexao.getConexao();
    static HashSenhas hs = new HashSenhas();






   public boolean usuarioisAdmin(String email) throws SQLException{

       String sql = "SELECT * FROM usuarios WHERE email = ?";
       PreparedStatement pstmt = conexao.prepareStatement(sql);
       pstmt.setString(1,email);
       ResultSet resultado = pstmt.executeQuery();
       resultado.next();


       return resultado.getBoolean("isadmin");





      }
      public boolean usuarioExiste(String email){
       String sql = "SELECT * FROM usuarios WHERE email = ?";
       try {
           PreparedStatement pstmt = conexao.prepareStatement(sql);
           pstmt.setString(1,email);
           ResultSet resultado = pstmt.executeQuery();
           return  resultado.next();
       }catch (SQLException e){
           throw new RuntimeException(e);
       }



      }





   public Usuario autenticacaoUsuario(String email, String senhaInserida) throws SQLException{
       String sql = "SELECT * FROM usuarios WHERE email = ?";
       PreparedStatement pstmt = conexao.prepareStatement(sql);


           pstmt.setString(1, email);

         ResultSet resultado = pstmt.executeQuery();

         
           if (resultado.next() ){
               if(hs.checkPassword(resultado.getString("salt") + senhaInserida,resultado.getString("hash"))){
                   System.out.println("Sucesso");
                   return new Usuario(email);
               }

           }
           else {
               if(!email.contains("@")|| !email.contains(".")||email.length()<6){
                   System.out.println("Email inválido!");
                   //TODO IMPLEMENTAR "ESQUECI MINHA SENHA".
                   return new GerenciadorLogin().perguntarCadastro();
               }
               else {
                   System.out.println("Email e/ou senha incorretos.");
                   return new GerenciadorLogin().perguntarCadastro();
               }
           }

        return null;
   }

    public static void main(String[] args) throws SQLException {
        VerificarUsuario vu = new VerificarUsuario();


    }



}
