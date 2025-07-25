package br.com.cbritodev.domain;

/**
 * @author carlos.brito
 * Criado em: 19/06/2025
 */
public class Endereco {
    private String rua;
    private Integer numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String rua, Integer numero, String cep, String bairro, String cidade, String estado){
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString(){
        return String.format(
                "%s %d, %s, %s, %s,%s",
                rua, numero,cep,bairro,cidade,estado
        );
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
}
