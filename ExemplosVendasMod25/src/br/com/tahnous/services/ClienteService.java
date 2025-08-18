package br.com.tahnous.services;

import br.com.tahnous.dao.IClienteDAO;
import br.com.tahnous.domain.Cliente;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.cadastrar(cliente);
        return  true;
    }

    @Override
    public void excluir(String cpf) {
        clienteDAO.excluir(cpf);
    }


    @Override
    public Cliente buscarPorCPF(String cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);

    }

}
