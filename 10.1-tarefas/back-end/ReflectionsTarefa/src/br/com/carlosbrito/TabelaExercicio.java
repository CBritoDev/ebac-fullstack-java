package br.com.carlosbrito;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */

public class TabelaExercicio {

    @Tabela("Exemplo Annotation")
    private String nome;

    public TabelaExercicio(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
