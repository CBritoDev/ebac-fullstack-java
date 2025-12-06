package br.com.carlosbrito;

import br.com.carlosbrito.dao.CursoDAO;
import br.com.carlosbrito.dao.ICursoDAO;
import br.com.carlosbrito.dao.MatriculaDAO;
import br.com.carlosbrito.domain.Curso;
import br.com.carlosbrito.domain.Matricula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public class CursoTest {

    private ICursoDAO cursoDao;
    private static Curso curso;


    public CursoTest(){
        this.cursoDao = new CursoDAO();
    }

    @BeforeEach
    public void criarCurso(){
        curso = new Curso();
        curso.setCodigo("0001");
        curso.setDescricao("Curso FXV");
        curso.setNome("Security APOTHC");
    }

    @Test
    public void cadastrar() throws Exception {
        Curso curso = new Curso();
        curso.setCodigo("0001");
        curso.setDescricao("Curso FXV");
        curso.setNome("Security APOTHC");

        ICursoDAO cursoDao =  new CursoDAO();

        curso = cursoDao.cadastrar(curso);
        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());
        cursoDao.excluir(curso.getId());
    }

    @Test
    public void consultarPorId() throws Exception{
        Curso curso01 = cursoDao.cadastrar(curso);
        Curso cursoRetorno = null;
        cursoRetorno = cursoDao.consultarPorId(curso01.getId());

        Assertions.assertNotNull(curso01);
        Assertions.assertEquals(curso01.getId(), cursoRetorno.getId());
        cursoDao.excluir(curso01.getId());
    }

    @Test
    public void excluir() throws Exception{
        Curso curso01 = cursoDao.cadastrar(curso);

        Curso retorno = cursoDao.consultarPorId(curso01.getId());

        long excluiu = cursoDao.excluir(curso01.getId());

        Assertions.assertEquals(1, excluiu);
    }

    @Test
    public void buscarTodos() throws Exception {
        Curso curso02 =  new Curso();
        curso02.setCodigo("0002");
        curso02.setDescricao("Curso PLSD");
        curso02.setNome("Alternaty APOTHC");

        Curso curso01 = cursoDao.cadastrar(curso);
        curso02 = cursoDao.cadastrar(curso02);

        Assertions.assertNotNull(curso01.getId());
        Assertions.assertNotNull(curso02.getId());

        List<Curso> listaCursos = cursoDao.buscarTodos();

        Assertions.assertNotNull(listaCursos);
        Assertions.assertTrue(listaCursos.size() >= 2,
                "O método buscarTodos() não retornou pelo menos 2 cursos.");

        for(Curso c : listaCursos){
            cursoDao.excluir(c.getId());
        }

    }

    @Test
    public void alterar() throws Exception{
        Curso curso02 =  new Curso();
        curso02.setCodigo("0002");
        curso02.setDescricao("Curso PLSD");
        curso02.setNome("Alternaty APOTHC");

        curso02 = cursoDao.cadastrar(curso02);

        curso02.setNome("Renomeado");

        Curso retorno = cursoDao.alterar(curso02);

        Curso cursoRetorno = cursoDao.consultarPorId(curso02.getId());

        Assertions.assertNotNull(cursoRetorno, "Não deve ser nulo");
        Assertions.assertEquals("Renomeado", cursoRetorno.getNome());

        cursoDao.excluir(cursoRetorno.getId());
        Assertions.assertNull(cursoDao.consultarPorId(cursoRetorno.getId()));
    }


}


