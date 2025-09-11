package br.com.carlosbrito.generics;

import br.com.carlosbrito.dao.ClienteDAOMock;
import br.com.carlosbrito.dao.SingletonMap;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.services.generics.GenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class ServiceClienteTest {
    private ClienteDAOMock clienteDao;

    private Cliente cliente;
    private Cliente cliente2;
    private Cliente cliente3;
    private GenericService genericService;

    public ServiceClienteTest(){
        clienteDao = new ClienteDAOMock();
        genericService =  new GenericService<>(clienteDao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {

        SingletonMap.getInstance().clear();

        cliente = new Cliente();
        cliente.setCpf(12312312312l);
        cliente.setNome("Carlos");
        cliente.setCidade("Pará de Minas");
        cliente.setEndereco("Rua Teste");
        cliente.setNumero(123);
        cliente.setEstado("MG");
        cliente.setNumero(40028922);

        cliente2 = new Cliente();
        cliente2.setCpf(12312312312l);
        cliente2.setNome("Carlos");
        cliente2.setCidade("Pará de Minas");
        cliente2.setEndereco("Rua Teste");
        cliente2.setNumero(123);
        cliente2.setEstado("MG");
        cliente2.setNumero(40028922);

        cliente3 = new Cliente();
        cliente3.setCpf(23324l);
        cliente3.setNome("Pedro");
        cliente3.setCidade("Pará de Minas");
        cliente3.setEndereco("Rua Teste");
        cliente3.setNumero(123);
        cliente3.setEstado("MG");
        cliente3.setNumero(40028922);
    }

    @Test
    public void deveCadastrarCliente() throws TipoChaveNaoEncontradaException {
        Boolean resposta = genericService.cadastrar(cliente);
        Assert.assertTrue(resposta);
    }

    @Test
    public void deveExcluirCliente() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(cliente);
        Boolean resposta = genericService.excluir(cliente.getCpf());
        Assert.assertTrue(resposta);
    }

    @Test
    public void deveConsultarERetornarCliente() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(cliente);
        Cliente clienteRetorno = (Cliente) genericService.consultar(cliente.getCpf());
        Assert.assertEquals("Deve ser o mesmo cliente", cliente,clienteRetorno);
    }


    @Test
    public void deveAlterarCliente() throws TipoChaveNaoEncontradaException{
        genericService.cadastrar(cliente);
        genericService.alterar(cliente2);
        Cliente clienteRetorno =  (Cliente) genericService.consultar(cliente.getCpf());
        Assert.assertEquals("Cliente deve conter novos dados", cliente2, clienteRetorno);
    }

    @Test
    public void deveRetornarMapaDeClientes() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(cliente);
        genericService.cadastrar(cliente3);
        Collection<Cliente> mapaClientes =  genericService.buscarTodos();
        mapaClientes.forEach(System.out::println);
        Assert.assertNotNull(mapaClientes);
    }
}
