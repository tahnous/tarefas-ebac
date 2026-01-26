/**
 *
 */
package br.com.tahnous.services;

import br.com.tahnous.dao.IProdutoDAO;
import br.com.tahnous.dao.generic.IGenericDAO;
import br.com.tahnous.domain.Produto;
import br.com.tahnous.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super((IGenericDAO<Produto, String>) dao);
    }

}
