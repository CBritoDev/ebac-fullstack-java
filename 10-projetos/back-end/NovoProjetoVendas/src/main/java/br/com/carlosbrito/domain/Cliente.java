package br.com.carlosbrito.domain;

import br.com.carlosbrito.anotation.TipoChave;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class Cliente implements Persistente{

    private String nome;
    @TipoChave("getCpf")
    private Long cpf;
    private Long tel;
    private String endereco;
    private Integer numero;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", tel=" + tel +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
