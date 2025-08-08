package br.com.tahnous.tests;

import br.com.tahnous.pessoa.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class TestePopularPessoaTest {

    private InputStream originalSystemIn;
    @BeforeEach
    void setUp() {
        originalSystemIn = System.in; // Store original System.in
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn); // Restore original System.in
    }

    @Test
    public void testPopularFeminino() {
        String simulatedInput = "Jessica - FEMININO, Luana - FEMININO, Flavia - FEMININO \n";
        String[] expectedResult = {"FEMININO", "FEMININO", "FEMININO"};
        ArrayList<String> resultPessoas = new ArrayList<String>();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        Stream<Pessoa> pessoaStream = Pessoa.popularPessoasFeminino();
        pessoaStream.forEach(pessoa -> resultPessoas.add(pessoa.getSexo()));

        assertArrayEquals(expectedResult,resultPessoas.toArray());


    }
}