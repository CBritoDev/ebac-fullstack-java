package br.com.carlosbrito.model;

import java.util.Scanner;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class PessoaFisica extends Pessoa {

    Scanner input = new Scanner(System.in);

    private Long cpf;
    private String dataNascimento;


    public PessoaFisica(){}

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    /**
     * @return Retorna CPF válido para a variavel cpf
     */
    @Override
    public Long getIdentificacao() {
        return cpf;
    }

    /**
     * Captura CPF e faz validação
     */
    public void capturaCPF(){
        System.out.println("Digite apenas os  números do CPF:  ");
        while(true){
            cpf = input.nextLong();
            input.nextLine();
            if(!isValidDocument()){
                System.out.println("Digite um CPF válido");
            }else{
                break;
            }
        }
    }

    /**
     * Lê os dados do usuário e guarda nas variáveis respectivas
     */
    public void capturaDados(){
        System.out.println("Digite seu nome: ");
        this.setNome(input.nextLine());
        capturaCPF();
        System.out.println("Digite sua data de nascimento");
        this.dataNascimento = input.nextLine();
        System.out.println("Digite o seu endereço: ");
        this.setEndereco(input.nextLine());

    }

    /**
     *
     * @return Retorna se o CPF é válido ou não
     */
    @Override
    public boolean isValidDocument() {
        return String.valueOf(cpf).length() == 11;
    }


    public void imprimeDados(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Endereço: " + getEndereco());
    }

}
