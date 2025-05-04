package br.com.carlosbrito.model;

import br.com.carlosbrito.util.IDocumentoValido;

/**
 * Classe abstrata que representa uma pessoa genérica, com nome e endereço.
 * Deve ser estendida por classes que definem uma identificação única e validam seu documento.
 *
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public abstract class Pessoa implements IDocumentoValido {

    private String nome;
    private String endereco;

    public abstract Long getIdentificacao();
    public abstract void capturaDados();
    public abstract void imprimeDados();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
