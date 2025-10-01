package br.com.tahnous.dao;

import br.com.tahnous.domain.Produto;

import java.util.List;

public interface IProdutoDao {

        public Produto cadastrar(Produto produto);

        public void excluir(Produto produto);

        public List<Produto> buscarTodos();
}

