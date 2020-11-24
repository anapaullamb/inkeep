package ana.paula.inkeep.dao;

import ana.paula.inkeep.entidade.Tarefa;
import ana.paula.inkeep.util.ErroSistema;
import ana.paula.inkeep.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements CrudDAO<Tarefa>{
    
    @Override
    public void salvar(Tarefa tarefa) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(tarefa.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO tarefa(titulo,concluido) VALUES (?,?)");
            } else {
                ps = conexao.prepareStatement("update tarefa set titulo=?, concluido=? where id=?");
                ps.setInt(3, tarefa.getId());
            }
            ps.setString(1, tarefa.getTitulo());
            ps.setBoolean(2, tarefa.getConcluido());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
    
    @Override
    public void deletar(Tarefa tarefa) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from tarefa where id = ?");
            ps.setInt(1, tarefa.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }
    
    @Override
    public List<Tarefa> listar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from tarefa order by concluido asc");
            ResultSet resultSet = ps.executeQuery();
            List<Tarefa> tarefas = new ArrayList<>();
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getBoolean("concluido"));
                tarefas.add(tarefa);
            }
            FabricaConexao.fecharConexao();
            return tarefas;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao lista!", ex);
        }
    }
}
