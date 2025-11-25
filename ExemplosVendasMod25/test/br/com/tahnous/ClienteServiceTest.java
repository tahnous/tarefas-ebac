package br.com.tahnous;

import br.com.tahnous.dao.ClienteDaoMock;
import br.com.tahnous.dao.IClienteDAO;
import br.com.tahnous.domain.Cliente;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;
import br.com.tahnous.services.ClienteService;
import br.com.tahnous.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf("12312312312");
        cliente.setNome("Rodrigo");
        cliente.setCidade("Sao Paulo");
        cliente.setEstado("SP");
        cliente.setEnd("End");
        cliente.setNumero(10);
        cliente.setTel(119999999999L);

    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteService.alterar(cliente);
        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }
}
