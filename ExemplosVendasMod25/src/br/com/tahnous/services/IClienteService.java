package br.com.tahnous.services;

import br.com.tahnous.domain.Cliente;
import br.com.tahnous.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {


    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    void excluir(String cpf);
    Cliente buscarPorCPF(String cpf);
    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;;
}
