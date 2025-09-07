package br.com.carlosbrito;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public class ListaTests {
    @Test
    public void listaDeveConterApenasMulheres(){
        List<Pessoa> pessoasTodosGeneros = Arrays.asList(
                new Pessoa("Marcos", "masculino"),
                new Pessoa("Pedro","masculino"),
                new Pessoa("Marta","feminino"),
                new Pessoa("Barbara", "feminino")
        );
        Predicate<Pessoa> isFeminino = pessoa -> pessoa.getGenero().equalsIgnoreCase("feminino");
        List<Pessoa> mulheres = pessoasTodosGeneros.stream()
                .filter(isFeminino)
                .collect(Collectors.toList());
        Assert.assertTrue("A lista deve conter apenas mulheres.",mulheres.stream().allMatch(isFeminino));
    }
}