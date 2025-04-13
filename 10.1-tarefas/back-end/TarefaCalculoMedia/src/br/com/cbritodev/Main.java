package br.com.cbritodev;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Calculadora media = new Calculadora();
        Mensagens m = new Mensagens();
        EntradaDados notas = new EntradaDados(scanner);

        m.printNow("**************");
        m.printNow("Bem vindo(a) à br.com.cbritodev.Calculadora de médias da EBAC!");

        notas.leituraNotas(media);
        media.calcularMedia();
        double resultadoMedia = media.getMedia();

        if(resultadoMedia >= 7){
            m.printNow("Parabéns! Aprovado. Média: " + resultadoMedia);
        }else if(resultadoMedia >= 5){
            m.printNow("Recuperação. Média: " + resultadoMedia);
        }else{
            m.printNow(("REPROVADO! Média: " + resultadoMedia));
        }
    }
}