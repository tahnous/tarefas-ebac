package br.com.tahnous.dao;

public class ClienteDao implements IClienteDao {


    public String salvar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    public void buscar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");

    }
}
