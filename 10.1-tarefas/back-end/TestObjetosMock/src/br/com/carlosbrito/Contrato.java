package br.com.carlosbrito;

import java.util.Objects;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class Contrato {
    private int id;
    private String data;

    public Contrato(int id, String data){
        this.id = id;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id && Objects.equals(data, contrato.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}
