package br.com.tahnous;

import br.com.tahnous.dao.IProdutoDao;
import br.com.tahnous.dao.ProdutoDao;
import br.com.tahnous.domain.Curso;
import br.com.tahnous.domain.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoTest {

    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();

    }

    @AfterEach
    public void end() {
        List <Produto> listProdutos = produtoDao.buscarTodos();
        listProdutos.forEach(prod -> produtoDao.excluir(prod));
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("A0");
        produto.setNome("Java Backend");
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }

}
