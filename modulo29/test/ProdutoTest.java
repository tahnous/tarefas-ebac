import br.com.tahnous.dao.jdbc.IProdutoDAO;
import br.com.tahnous.dao.jdbc.ProdutoDAO;
import br.com.tahnous.domain.Cliente;
import br.com.tahnous.domain.Produto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

    public static String generateRandomString(int length) {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            sb.append(characterSet.charAt(index));
        }
        return sb.toString();
    }

    @Test
    public void cadastrarTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setPreco(1.99F);
        produto.setNome("Impressora");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(),produtoBD.getPreco(), 0.0001);

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setPreco(1.99F);
        produto.setNome("Impressora");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(),produtoBD.getPreco(), 0.0001);

        produtoBD.setNome("Impressora EPSON");
        produtoBD.setCodigo("xxx");
        produtoBD.setPreco(3.99F);
        qtd = dao.atualizar(produtoBD);
        assertTrue(qtd >= 1);

        produto = dao.consultar(produtoBD.getCodigo());
        assertNotNull(produto);
        assertNotNull(produto.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getId(), produtoBD.getId());
        assertEquals(produto.getPreco(),produtoBD.getPreco(), 0.0001);

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);

    }

    @Test
    public void buscarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<>();

        for (String nomeProduto : new String[]{"Impressora", "Mouse", "Teclado", "Monitor"}) {
            Produto produto = new Produto(nomeProduto,generateRandomString(4), 2.99F);
            Integer qtd = dao.cadastrar(produto);
            assertTrue(qtd == 1);
            Produto produtoBD = dao.consultar(produto.getCodigo());
            produtos.add(produtoBD);
        }
        List<Produto> produtosBD = dao.buscarTodos();
        assertNotNull(produtosBD);
        assertEquals(produtos.size(),produtosBD.size());

        for (int i = 0; i < produtos.size(); i++) {
            assertEquals(produtosBD.get(i).getCodigo(),produtos.get(i).getCodigo());
            assertEquals(produtosBD.get(i).getNome(),produtos.get(i).getNome());
            assertEquals(produtosBD.get(i).getId(),produtos.get(i).getId());
            assertEquals(produtosBD.get(i).getPreco(),produtos.get(i).getPreco(),0.0001);
        }
        for (Produto p : produtosBD) {
            Integer qtdDel = dao.excluir(p);
            assertNotNull(qtdDel);

        }

    }
}
