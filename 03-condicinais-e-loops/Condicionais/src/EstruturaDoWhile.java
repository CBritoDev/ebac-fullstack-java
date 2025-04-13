import java.util.Scanner;

public class EstruturaDoWhile {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        String resposta = "";

        do{
            System.out.print("Digite um número para gerar a tabuada: ");
            int num = s.nextInt();
            for(int i = 0; i <= 10; i++){
                System.out.println(num + " x " + i + " = " + num*i);
            }

            System.out.println("Deseja gerar novamente a tabuada de algum número? ");
            resposta = s.next();
        }while (resposta.equalsIgnoreCase("Sim"));
        System.out.println("Obrigado");
    }
}

