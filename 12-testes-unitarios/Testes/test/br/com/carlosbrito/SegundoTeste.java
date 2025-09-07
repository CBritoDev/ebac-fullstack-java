package br.com.carlosbrito.testes;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author carlos.brito
 * Criado em: 06/09/2025
 */
public class SegundoTeste {

    @Test
    public void test2(){
        String nome =  "Carlos";
        Assert.assertEquals("Carlos", nome);
    }
}
