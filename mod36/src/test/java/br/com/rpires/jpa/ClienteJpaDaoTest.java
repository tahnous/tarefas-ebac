/**
 * 
 */
package br.com.rpires.jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.rpires.dao.jpa.ClienteJpaDAO;
import br.com.rpires.dao.jpa.IClienteJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDaoTest {

	private IClienteJpaDAO<ClienteJpa> clienteDao;

	private Random rd;

	public ClienteJpaDaoTest() {
		this.clienteDao = new ClienteJpaDAO();
		rd = new Random();
	}

	@AfterEach
	public void end() throws DAOException {
		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJpa cliente = criarCliente();
		clienteDao.cadastrar(cliente);

		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);

	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		assertNotNull(retorno);

		ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
		assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente);

		ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
		assertNull(clienteConsultado1);
	}

	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		assertNotNull(retorno);

		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNull(clienteConsultado);
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		assertNotNull(retorno);

		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);

		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.alterar(clienteConsultado);

		ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		assertNotNull(clienteAlterado);
		assertEquals("Rodrigo Pires", clienteAlterado.getNome());

		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		assertNull(clienteConsultado);
	}

	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		assertNotNull(retorno);

		ClienteJpa cliente1 = criarCliente();
		ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
		assertNotNull(retorno1);

		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}

	private ClienteJpa criarCliente() {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}
