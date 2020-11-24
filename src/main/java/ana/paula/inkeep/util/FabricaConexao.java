package ana.paula.inkeep.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static Connection conexao;
    private static final String URL_CONEXAO= "jdbc:postgresql://ec2-54-82-208-124.compute-1.amazonaws.com:5432/d20d6rjjchgue0";
    private static final String USUARIO= "fzejdwybqdiyrj";
    private static final String SENHA= "b7e1832a6413a42830294d387f501e71a1a57bd70bd85b193cec2906430078aa";

    public static Connection getConexao() throws ErroSistema{
        if(conexao == null){
            try {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                throw new ErroSistema("Não foi possivel conectar ao banco de dados!", ex);
            } catch (ClassNotFoundException ex) {
                throw new ErroSistema("O driver do banco de dados não foi encontrado!", ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao() throws ErroSistema{
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao fechar conexão com o banco de dados!", ex);
            }
        }
    }
    
    
    
    
}
