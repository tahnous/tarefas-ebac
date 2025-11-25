package br.com.tahnous.dao;

import br.com.tahnous.domain.Marca;

import java.util.List;

public interface IMarcaDao {

    public Marca cadastrar(Marca marca);
    public List<Marca> buscarTodos();
    public void excluir(Marca marca);
}
