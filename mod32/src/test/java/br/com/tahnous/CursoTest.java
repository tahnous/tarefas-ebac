package br.com.tahnous;

import br.com.tahnous.dao.CursoDao;
import br.com.tahnous.dao.ICursoDao;
import br.com.tahnous.domain.Curso;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @AfterEach
    public void end() {
        List<Curso> listCursos = cursoDao.buscarTodos();
        listCursos.forEach(cur -> cursoDao.excluir(cur));
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A3");
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}
