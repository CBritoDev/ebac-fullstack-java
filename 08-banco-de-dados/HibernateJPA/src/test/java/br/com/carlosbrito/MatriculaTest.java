package br.com.carlosbrito;

import br.com.carlosbrito.dao.IMatriculaDAO;
import br.com.carlosbrito.dao.MatriculaDAO;
import br.com.carlosbrito.domain.Curso;
import br.com.carlosbrito.domain.Matricula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public class MatriculaTest {

    private IMatriculaDAO matriculaDao;
    private static Matricula matriculaTeste;

    public MatriculaTest(){
        this.matriculaDao = new MatriculaDAO();
    }

    @BeforeEach
    public void criarMatricula(){
        matriculaTeste = new Matricula();
        matriculaTeste.setCodigo("xxxxxx");
        matriculaTeste.setDataMatricula(Instant.now());
        matriculaTeste.setValor(BigDecimal.valueOf(399.90));
        matriculaTeste.setStatus('A');
    }


    @Test
    public void cadastrar() throws Exception {
        Matricula matricula = new Matricula();
        matricula.setCodigo("abcde01");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus('A');
        matricula.setValor(BigDecimal.valueOf(399.99));

        matricula = matriculaDao.cadastrar(matricula);

        Assertions.assertNotNull(matricula);
        Assertions.assertNotNull(matricula.getId());

    }

    @Test
    public void consultarPorId() throws Exception{
        Matricula matricula01 = matriculaDao.cadastrar(matriculaTeste);
        Matricula matriculaRetorno = null;
        matriculaRetorno = matriculaDao.consultarPorId(matricula01.getId());

        Assertions.assertNotNull(matricula01);
        Assertions.assertEquals(matricula01.getId(), matriculaRetorno.getId());
    }

    @Test
    public void excluir() throws Exception{
        Matricula matricula01 = matriculaDao.cadastrar(matriculaTeste);

        Matricula retorno = matriculaDao.consultarPorId(matricula01.getId());

        long excluiu = matriculaDao.excluir(matricula01.getId());

        Assertions.assertEquals(1, excluiu);
    }

    @Test
    public void buscarTodos() throws Exception {
        Matricula matricula02 =  new Matricula();
        matricula02.setCodigo("abcde01");
        matricula02.setDataMatricula(Instant.now());
        matricula02.setStatus('A');
        matricula02.setValor(BigDecimal.valueOf(399.99));

        Matricula matricula01 = matriculaDao.cadastrar(matriculaTeste);
        matricula02 = matriculaDao.cadastrar(matricula02);

        Assertions.assertNotNull(matricula01.getId());
        Assertions.assertNotNull(matricula02.getId());

        List<Matricula> listaMatriculas = matriculaDao.buscarTodos();

        Assertions.assertNotNull(listaMatriculas);
        Assertions.assertTrue(listaMatriculas.size() >= 2,
                "O método buscarTodos() não retornou pelo menos 2 matriculas.");

        for(Matricula c : listaMatriculas){
            matriculaDao.excluir(c.getId());
        }

    }

    @Test
    public void alterar() throws Exception{
        Matricula matricula02 =  new Matricula();
        matricula02.setCodigo("abcde01");
        matricula02.setDataMatricula(Instant.now());
        matricula02.setStatus('A');
        matricula02.setValor(BigDecimal.valueOf(399.99));

        matricula02 = matriculaDao.cadastrar(matricula02);

        matricula02.setCodigo("Renomeado");

        Matricula retorno = matriculaDao.alterar(matricula02);

        Matricula matriculaRetorno = matriculaDao.consultarPorId(matricula02.getId());

        Assertions.assertNotNull(matriculaRetorno, "Não deve ser nulo");
        Assertions.assertEquals("Renomeado", matriculaRetorno.getCodigo());

        matriculaDao.excluir(matriculaRetorno.getId());
        Assertions.assertNull(matriculaDao.consultarPorId(matriculaRetorno.getId()));
    }


}
