package sistemachamados.usuariosDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBaseDeUsuarios {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE dbUsuarios");
        System.out.println("Banco criado com sucesso!");
        conexao.close();
    }


}
