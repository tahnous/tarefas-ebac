package br.com.tahnous;

import br.com.tahnous.dao.ClienteDAO;
import br.com.tahnous.dao.ClienteDaoMock;
import br.com.tahnous.dao.IClienteDAO;
import br.com.tahnous.domain.Cliente;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf("12312312312");
        cliente.setNome("Rodrigo");
        cliente.setCidade("Sao Paulo");
        cliente.setEstado("SP");
        cliente.setEnd("End");
        cliente.setNumero(10);
        cliente.setTel(119999999999L);

        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }
}
