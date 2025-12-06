package br.com.carlosbrito.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
@Entity
@Table(name = "MATRICULA")
public class Matricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "matricula_sq")
    @SequenceGenerator(name = "matricula_sq",sequenceName = "sq_matricula", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODIGO",length = 15,nullable = false, unique = true)
    private String codigo;

    @Column(name = "DATA_MATRICULA",nullable = false)
    private Instant dataMatricula;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "STATUS",length = 1,nullable = false)
    private Character status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
