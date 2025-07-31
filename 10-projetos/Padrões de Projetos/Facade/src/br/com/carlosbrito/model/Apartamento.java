package br.com.carlosbrito.model;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public class Apartamento {
    private Long codigo;
    private String endereço;

    public Apartamento(long codigo, String endereço) {
        this.codigo = codigo;
        this.endereço = endereço;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
