package br.com.carlosbrito.composicao;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class App {
    public static void main(String[] args){
        Banco banco = new Banco();
        banco.setCodigo(10L);
        banco.setNome("Santander");

        ContaCorrente cc = new ContaCorrente(banco, 1000d, 4000d);
        System.out.println(cc);

        ContaPoupanca cp = new ContaPoupanca(banco, 2000d);
        System.out.println(cp);


    }
}
