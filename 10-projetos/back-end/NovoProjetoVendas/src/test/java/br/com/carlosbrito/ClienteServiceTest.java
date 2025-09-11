package br.com.carlosbrito;

import br.com.carlosbrito.dao.ClienteDAOMock;
import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.services.ClienteService;
import br.com.carlosbrito.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao =  new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312l);
        cliente.setNome("Carlos");
        cliente.setCidade("Pará de Minas");
        cliente.setEndereco("Rua Teste");
        cliente.setNumero(123);
        cliente.setEstado("MG");
        cliente.setNumero(40028922);
        clienteService.cadastrar(cliente);
    }


    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado =  clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        clienteService.cadastrar(cliente);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Carlos Brito");
        clienteService.alterar(cliente);

        Assert.assertEquals("Carlos Brito", cliente.getNome());
    }


}
