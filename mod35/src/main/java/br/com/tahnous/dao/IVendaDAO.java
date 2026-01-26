/**
 *
 */
package br.com.tahnous.dao;

import br.com.tahnous.dao.generic.IGenericDAO;
import br.com.tahnous.domain.Venda;
import br.com.tahnous.exceptions.DAOException;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
