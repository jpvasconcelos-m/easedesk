package sistemachamados.usuariosDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriadorTabelaChamados {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        String sql = """
        CREATE TABLE IF NOT EXISTS chamados(
        IDchamado SERIAL PRIMARY KEY,
        Descricao VARCHAR(20000) NOT NULL,
        Solucao VARCHAR (20000),
        UsuarioResponsavel VARCHAR (100),
        UsuarioSolicitante VARCHAR(100) NOT NULL,
        Status VARCHAR (25) NOT NULL
    );
""";




        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela de chamados criada com sucesso!");

    }


}
