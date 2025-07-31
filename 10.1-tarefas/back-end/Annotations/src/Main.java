import br.com.carlosbrito.Tabela;

/**
 * @author carlos.brito
 * Criado em: 31/07/2025
 */
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        print("Teste anotação");
    }

    @Tabela("Nome da tabela")
    private static void print(String x){
        System.out.println(x);
    }
}