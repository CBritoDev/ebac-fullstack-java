package br.com.carlosbrito.domain;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "sq_curso",initialValue = 1,allocationSize = 1)
    private long id;

    @Column(name = "CODIGO",length = 10,nullable = false,unique = true)
    private String codigo;

    @Column(name = "NOME",length = 55,nullable = false)
    private String nome;

    @Column(name = "DESCRICAO",length = 100,nullable = false)
    private String descricao;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
