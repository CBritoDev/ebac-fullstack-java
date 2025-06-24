package br.com.cbritodev.domain;

import java.util.Objects;

/**
 * @author carlos.brito
 * Criado em: 19/06/2025
 */
public class Cliente {

    private String nome;
    private final long cpf;
    private long tel;
    private Endereco endereco;


    public Cliente(String nome, long cpf, long tel, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getCpf() {
        return cpf;
    }


    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf == cliente.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return String.format(
                "Cliente: %s" + "\n"
                        + "CPF: %d" + "\n" + "Telefone: %d" + "\n" + "Endereço: %s",
                nome, getCpf(), tel, getEndereco()

        );
    }
}
