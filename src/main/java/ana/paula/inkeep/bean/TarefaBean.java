package ana.paula.inkeep.bean;

import ana.paula.inkeep.dao.TarefaDAO;
import ana.paula.inkeep.entidade.Tarefa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TarefaBean extends CrudBean<Tarefa, TarefaDAO>{

    private TarefaDAO tarefaDAO;
    
    @Override
    public TarefaDAO getDao() {
        if(tarefaDAO == null){
            tarefaDAO = new TarefaDAO();
        }
        return tarefaDAO;
    }

    @Override
    public Tarefa criarNovaEntidade() {
        return new Tarefa(false);
    }
}
