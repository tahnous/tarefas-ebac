import br.com.tahnous.dao.jdbc.ClienteDAO;
import br.com.tahnous.dao.jdbc.IClienteDAO;
import br.com.tahnous.domain.Cliente;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteTest {


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
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setNome("Rodrigo Pires 2");
        clienteBD.setCodigo("xxx");

        qtd = dao.atualizar(clienteBD);
        assertTrue(qtd >= 1);

        cliente = dao.consultar(clienteBD.getCodigo());
        assertNotNull(cliente);
        assertNotNull(cliente.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getId(), clienteBD.getId());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);

    }

    @Test
    public void buscarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = new ArrayList<>();

        for (String nomeCliente : new String[]{"Rodrigo Pires", "Marcela Souza", "Marcos Gama", "Antonio Costa"}) {
            Cliente cliente = new Cliente(nomeCliente,generateRandomString(4));
            Integer qtd = dao.cadastrar(cliente);
            assertTrue(qtd == 1);
            Cliente clienteBD = dao.consultar(cliente.getCodigo());
            clientes.add(clienteBD);
        }
        List<Cliente> clientesBD = dao.buscarTodos();
        assertNotNull(clientesBD);
        assertEquals(clientes.size(),clientesBD.size());
        for (int i = 0; i < clientes.size(); i++) {
            assertEquals(clientesBD.get(i).getCodigo(),clientes.get(i).getCodigo());
            assertEquals(clientesBD.get(i).getNome(),clientes.get(i).getNome());
            assertEquals(clientesBD.get(i).getId(),clientes.get(i).getId());

        }
        for (Cliente c : clientesBD) {
            Integer qtdDel = dao.excluir(c);
            assertNotNull(qtdDel);

        }
    }
}

