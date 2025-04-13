package br.com.cbritodev;

import java.util.Scanner;

public class EntradaDados {
    private Scanner scanner;

    public EntradaDados(Scanner scanner){
        this.scanner = scanner;
    }

    public void leituraNotas(Calculadora notas){
        System.out.print("Digite a nota de Português: ");
        notas.setNota1(scanner.nextDouble());

        System.out.print("Digite a nota de Matématica: ");
        notas.setNota2(scanner.nextDouble());

        System.out.print("Digite a nota de Redação: ");
        notas.setNota3(scanner.nextDouble());

        System.out.print("Digite a nota de Ciências: ");
        notas.setNota4(scanner.nextDouble());
    }
}
