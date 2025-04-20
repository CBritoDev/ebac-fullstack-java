package br.com.cbritodeveloper.domain;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{

    private String nome;
    private String curso;
    private double nota;
    private String sala;

    public Aluno(String nome, String curso, double nota){
        this.nome = nome;
        this.curso = curso;
        this.nota = nota;
    }

    public Aluno(String nome, String curso,double nota, String sala){
        this(nome, curso, nota);
        this.sala=sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Usado para converter o objeto em String
     *
     * @return
     */
    public String toString() {
        return  this.nome;
    }

    /**
     * Usado para comparação entre objetos e verificat se o mesmo é igual
     * @param aluno
     * @return
     */
   public int compareTo(Aluno aluno){
        return this.nome.compareTo(aluno.getNome());
    }


    /**
     * Barra duplicidade apenas pelo nome
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    /**
     * Filtra todas as informações do objeto para comparação, e se uma for diferente, aceita duplicidade
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Aluno aluno = (Aluno) o;
//        return Double.compare(nota, aluno.nota) == 0 && Objects.equals(nome, aluno.nome) && Objects.equals(curso, aluno.curso) && Objects.equals(sala, aluno.sala);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome, curso, nota, sala);
//    }
}
