package br.com.tahnous;

import br.com.tahnous.dao.*;
import br.com.tahnous.domain.Acessorio;
import br.com.tahnous.domain.Carro;
import br.com.tahnous.domain.Marca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarroTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;


    public CarroTest() {
        carroDao =  new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }
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
    @AfterEach
    public void end() {
        List<Carro> listCarros = carroDao.buscarTodos();
        List<Marca> listMarcas = marcaDao.buscarTodos();

        listCarros.forEach(car -> carroDao.excluir(car));
        listMarcas.forEach(m -> marcaDao.excluir(m));

   }
    @Test
    public void cadastrar() {
        Carro carro = new Carro();
        carro.setCodigo(generateRandomString(5));
        carro.setNome("Carro Teste");
        carro.setValor(55000.0);
        Marca marca =  criarMarca(generateRandomString(5));
        carro.setMarca(marca);
        Acessorio acessorio = criarAcessorio(generateRandomString(5), carro);
        List<Acessorio> acessorios1 = new ArrayList<Acessorio>();
        acessorios1.add(acessorio);
        carro.setAcessorio(acessorios1);
        carro = carroDao.cadastrar(carro);
        assertNotNull(carro);
        assertNotNull(carro.getId());
        assertNotNull(carro.getAcessorio());
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome(" Marca Teste");
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio (String codigo, Carro carro) {
        Acessorio acessorio = new Acessorio();
        Marca marca = criarMarca(generateRandomString(5));
        acessorio.setMarca(marca);
        acessorio.setCodigo(codigo);
        acessorio.setNome("Acessorio teste");
        acessorio.setDescricao("Acessorio descricao teste");
        acessorio.setCarro(carro);
        return acessorioDao.cadastrar(acessorio);

    }
}
