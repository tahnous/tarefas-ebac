package br.com.tahnous.dao;

import br.com.tahnous.domain.Cliente;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ClienteDaoMock implements  IClienteDAO{



    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public void excluir(String cpf) {

    }


    @Override
    public void alterar(Cliente cliente) {

    }

    @Override
    public Cliente consultar(String valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return List.of();
    }
}
