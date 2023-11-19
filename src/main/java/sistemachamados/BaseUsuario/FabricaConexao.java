package sistemachamados.BaseUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    private final static String url = "jdbc:postgresql://localhost:5432/dbusuarios?verifyServerCertificate=false&&useSSL=true";
    private final static String user = "postgres";
    private final static String password = "root";

    public static Connection getConexao() {

        try{
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }



}
