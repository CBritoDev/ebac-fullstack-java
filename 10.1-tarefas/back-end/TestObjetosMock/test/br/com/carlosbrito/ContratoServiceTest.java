package br.com.carlosbrito;

import br.com.carlosbrito.dao.ContratoDao;
import br.com.carlosbrito.dao.IContratoDAO;
import br.com.carlosbrito.dao.mock.ContratoDaoMock;
import br.com.carlosbrito.service.ContratoService;
import br.com.carlosbrito.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public class ContratoServiceTest {

    @Test
    public void salvarTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato contrato =  new Contrato(1, "02/02/2003");
        String retorno = service.salvar(contrato);
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBandoDeDadosTest(){
        IContratoDAO dao =  new ContratoDao();
        IContratoService service = new ContratoService(dao);
        Contrato contrato =  new Contrato(1,"00/00/0000");
        String retorno = service.salvar(contrato);
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarContratoTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato contrato =  new Contrato(2,"00/00/0000");
        service.salvar(contrato);
        Contrato retornoContrato =  service.buscar(contrato.getId());
        Assert.assertEquals(new Contrato(2,"00/00/0000"), retornoContrato);
    }

    @Test
    public void excluirContratoTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato contrato =  new Contrato(1,"00/00/0000");
        service.salvar(contrato);
        service.excluir(1);
        Contrato retornoContrato = service.buscar(1);
        Assert.assertNull("Deve retornar nulo, ou seja, objeto não existe", retornoContrato);
    }

    @Test
    public void esperadoErroAoBuscarContratoInexistentetTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato retornoContrato =  service.buscar(1);
        Assert.assertNull("Deve retornar nulo, pois contrato não existe",retornoContrato);
    }

    @Test
    public void atualizarDadosContratoTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato contrato = new Contrato(1, "07/09/2025");
        service.salvar(contrato);
        Contrato contratoNovosDados =  new Contrato(1,"08/09/2025");
        service.atualizar(contratoNovosDados);
        Contrato retornoContratoAtualizado =  service.buscar(contratoNovosDados.getId());
        Assert.assertEquals(contratoNovosDados, retornoContratoAtualizado);

    }

    @Test
    public void listarDadosTest(){
        IContratoDAO dao =  new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        Contrato contrato = new Contrato(1, "07/09/2025");
        Contrato contrato2 = new Contrato(2, "08/09/2025");
        List<Contrato> listaEsperada = Arrays.asList(contrato,contrato2);
        service.salvar(contrato);
        service.salvar(contrato2);
        List<Contrato> contratos =  service.listar();
        Assert.assertTrue(contratos.containsAll(listaEsperada));
    }

}
