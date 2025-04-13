import java.util.Scanner;

public class EstruturaSWITCH {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.print("Digite sua idade:\n-->");
        int idade = s.nextInt();
        String idadeSt = getIdade(idade);
        System.out.print(idadeSt);
    }

    public static String getIdade( int idade){
        String result;
        switch (idade){
            case 0:
            case 5:
                result = "Você é um bebê!";
            case 6:
            case 10:
                result = "Você é uma criança!";
            case 11:
            case 17:
                result = "Você é um adolescente!";
                break;
            default:
                result = "Você é adulto";
                break;
        }return result;
    }
}
