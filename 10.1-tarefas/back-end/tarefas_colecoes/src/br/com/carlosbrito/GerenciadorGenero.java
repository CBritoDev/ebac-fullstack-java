package br.com.carlosbrito;

import java.util.*;

/**
 * @author carlos.brito
 */

public class GerenciadorGenero {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Seja bem vindo(a) ao Sistema gerenciador de genero");
        System.out.println("Digite os nomes e seus respectivos generos assim:  nome - genero, nome - genero");
        String nomeGenero = s.nextLine();
        String[] nomesSeparados = separarNomes(nomeGenero);

        Map<String, List<String>> grupoPessoas = separaGenero(nomesSeparados);

        System.out.println("Grupo de mulheres:\n" + grupoPessoas.get("mulheres"));
        System.out.println("Grupo de homens:\n" + grupoPessoas.get("homens"));
    }

    /**
     * Separa a string lida com o scanner em um array de elementos  nome - genero.
     *
     * @params nomeGenero Representa a string a ser tratada contendo os nomes e generos.
     * @return Retorna um array de grupos no formato nome - genero.
     */
    private static String[] separarNomes(String nomeGenero) {
        return nomeGenero.split(",");
    }

    /**
     * Separa os elementos nome - genero e testa o genero,
     * adicionando cada individuo num grupo específico (homens ou mulheres).
     *
     * O metodo assume que os dados de entrada são fornecidos no formato "nome - genero",
     * onde o genero pode ser "feminino" ou "masculino".
     *
     *@params Representa uma lista de entradas, onde cada item
     *                       contém um nome seguido por um hífen e o genero.
     *@return Retorna um Map com duas chaves ("mulheres" e "homens") associadas a listas
     *         de nomes, agrupados conforme o gênero.
     */
    private static Map<String, List<String>> separaGenero(String[] nomesSeparados) {
        List<String> grupoMulheres = new ArrayList<>();
        List<String> grupoHomens = new ArrayList<>();
        Map<String, List<String>> grupoPessoas = new HashMap<>();


        for (String nomesSeparado : nomesSeparados) {
            String nomesLowerCase = nomesSeparado.toLowerCase();
            if (nomesLowerCase.contains("feminino")) {
                String[] partes = nomesSeparado.split(" - ");
                grupoMulheres.add(partes[0]);
            } else if (nomesLowerCase.contains("masculino")) {
                String[] partes = nomesSeparado.split(" - ");
                grupoHomens.add(partes[0]);
            }
        }
        grupoPessoas.put("mulheres", grupoMulheres);
        grupoPessoas.put("homens",grupoHomens);

        return grupoPessoas;
    }
}