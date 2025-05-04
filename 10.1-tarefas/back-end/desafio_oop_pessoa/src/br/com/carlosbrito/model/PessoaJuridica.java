package br.com.carlosbrito.model;

import java.util.Scanner;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class PessoaJuridica extends Pessoa {

    Scanner input = new Scanner(System.in);

    private Long cnpj;
    private String razaoSocial;

    public PessoaJuridica() {

    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Testa a entrada CNPJ obtida pelo scanner
     *
     * @return Retorna CNPJ válido para a variavel cnpj
     */
    @Override
    public Long getIdentificacao() {
        return cnpj;
    }

    /**
     * Captura o cnpj e faz validação
     */
    public void capturaCNPJ(){
        System.out.println("Digite apenas os  números do CNPJ:  ");
        while(true){
            cnpj = input.nextLong();
            input.nextLine();
            if(!isValidDocument()){
                System.out.println("Digite um CNPJ válido");
            }else{
                break;
            }
        }
    }

    /**
     * Lê os dados do usuário e guarda nas variáveis respectivas
     */
    public void capturaDados(){
        capturaCNPJ();
        System.out.println("Digite a razão social: ");
        this.razaoSocial = input.nextLine();
        System.out.println("Digite o endereço da empresa: ");
        this.setEndereco(input.nextLine());
    }

    /**
     *
     * @return Retorna se o CNPJ é válido ou não
     */
    @Override
    public boolean isValidDocument() {
        return String.valueOf(cnpj).length() == 14;
    }

    public void imprimeDados(){
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + getEndereco());
    }
}
