package br.com.tahnous.service;

import br.com.tahnous.dao.ClienteDao;
import br.com.tahnous.dao.ClienteDaoMock;
import br.com.tahnous.dao.IClienteDao;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteServiceTest {

    @Test
    public void salvar() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso",retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroSalvar() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso",retorno);
    }

    public void buscar() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso",retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroBuscar() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso",retorno);
    }

    public void excluir () {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso",retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroExcluir() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso",retorno);
    }

    public void atualizar () {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.atualizar();
        Assert.assertEquals("Sucesso",retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAtualizar() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.atualizar();
        Assert.assertEquals("Sucesso",retorno);
    }


}