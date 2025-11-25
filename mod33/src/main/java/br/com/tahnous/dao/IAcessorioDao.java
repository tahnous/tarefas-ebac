package br.com.tahnous.dao;

import br.com.tahnous.domain.Acessorio;

import java.util.List;

public interface IAcessorioDao {

    public Acessorio cadastrar(Acessorio acessorio);
    public List<Acessorio> buscarTodos();
    public void excluir(Acessorio acessorio);
}
