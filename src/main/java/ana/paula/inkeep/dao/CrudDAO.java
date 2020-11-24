/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ana.paula.inkeep.dao;

import java.util.List;
import ana.paula.inkeep.util.ErroSistema;

/**
 *
 * @author anapa
 */
public interface CrudDAO<E> {
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> listar() throws ErroSistema;
    
}
