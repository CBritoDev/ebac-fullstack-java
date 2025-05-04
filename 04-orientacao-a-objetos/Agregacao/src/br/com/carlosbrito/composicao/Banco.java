package br.com.carlosbrito.composicao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class Banco {

    private Long codigo;

    private String nome;

    private Set<ContaCorrente> contasCorrente;

    private Set<ContaPoupanca> contasPoupanca;

    public Banco(){
        this.contasCorrente = new HashSet<>();
        this.contasPoupanca = new HashSet<>();
    }

    public void add(ContaCorrente c){
        this.contasCorrente.add(c);
    }
    public void add(ContaPoupanca p){
        this.contasPoupanca.add(p);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
