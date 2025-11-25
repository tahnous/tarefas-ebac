package br.com.tahnous.dao;

import br.com.tahnous.domain.Carro;
import br.com.tahnous.domain.Produto;

import java.util.List;

public interface ICarroDao {

    public Carro cadastrar(Carro carro);

    public void excluir(Carro carro);

    public List<Carro> buscarTodos();
}
