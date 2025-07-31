package br.com.carlosbrito.anotacao;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
@PrimeiraAnotacao(value = "Hello World", bairros = "Earth", numeroCasa = 12l)
public class ClasseComAnotacao {

    @PrimeiraAnotacao(value = "Hello World", bairros = {"Earth", "Sun"}, numeroCasa = 2025l, valores = 100d)
    private String nome;
}