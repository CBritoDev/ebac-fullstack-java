package br.com.carlosbrito.testes;

import br.com.carlosbrito.TesteCliente;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author carlos.brito
 * Criado em: 06/09/2025
 */
public class TesteClienteTest {

    @Test
    public void testeClasseCliente(){
        TesteCliente clie = new TesteCliente();
        clie.adicionarNome("Carlos");

        Assert.assertEquals("Carlos",clie.getNome());
    }

}
