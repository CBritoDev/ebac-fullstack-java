package br.com.carlosbrito.exercicio01.annotations.model;

import br.com.carlosbrito.exercicio01.annotations.NaoNulo;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
public class Usuario {

    @NaoNulo
    private String nome;
    @NaoNulo
    private String email;
    private Integer idade;

    public Usuario(String nome, String email, Integer idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
