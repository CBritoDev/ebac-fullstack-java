package br.com.carlosbrito.testes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author carlos.brito
 * Criado em: 06/09/2025
 */
public class PrimeiroTeste {

    @Test
    public void primeiroTeste(){
        String nome = "Carlos";
        Assert.assertEquals("Carlos", nome);
    }

    @Test
    public void testNotEquals(){
        String nome = "Carlos";
        Assert.assertNotEquals("Carloss",nome);
    }

}