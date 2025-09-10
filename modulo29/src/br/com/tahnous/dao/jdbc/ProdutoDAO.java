package br.com.tahnous.dao.jdbc;

import br.com.tahnous.domain.Cliente;
import br.com.tahnous.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO2 (ID, CODIGO, NOME, PRECO) VALUES (nextval('SQ_CLIENTE_2'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setFloat( 3, produto.getPreco());

            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        String sql = "UPDATE TB_PRODUTO2 SET nome = (?), preco = (?), codigo = (?) WHERE id = (?)";
        try {
            connection = ConnectionFactory.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setFloat(2, produto.getPreco());
            stm.setString(3,produto.getCodigo());
            stm.setLong(4,produto.getId());
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto2 where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));

            }
            return produto;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO2 WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        List <Produto> produtos = new java.util.ArrayList<>(List.of());
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto2";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                produtos.add(produto);
            }
            return produtos;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
