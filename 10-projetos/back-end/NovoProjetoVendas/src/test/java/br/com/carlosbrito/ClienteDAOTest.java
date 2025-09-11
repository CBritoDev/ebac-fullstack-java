package br.com.carlosbrito;

import br.com.carlosbrito.dao.ClienteDAO;
import br.com.carlosbrito.dao.ClienteDAOMock;
import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDao = new ClienteDAOMock();
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
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado =  clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void excluirCliente(){
        Boolean retorno  = clienteDao.excluir(cliente.getCpf());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Carlos Brito");
        clienteDao.cadastrar(cliente);

        Assert.assertEquals("Carlos Brito", cliente.getNome());
    }

}
