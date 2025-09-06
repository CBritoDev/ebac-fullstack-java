import br.com.carlosbrito.model.NomeGeneroLeitor;
import br.com.carlosbrito.model.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author carlos.brito
 * Criado em: 06/09/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NomeGeneroLeitor nomeGeneroLeitor = new NomeGeneroLeitor();
        String[] nomesGeneros = nomeGeneroLeitor.listaPessoas();

        List<Pessoa> pessoas = new ArrayList<>();
        for(int i = 0; i < nomesGeneros.length; i = 1 + 2){
            pessoas.add(new Pessoa(nomesGeneros[i], nomesGeneros[i + 1]));
        }

        Predicate<Pessoa> isFeminino = pessoa -> pessoa.getGenero().equalsIgnoreCase("feminino");
        Predicate<Pessoa> isMasculino = pessoa -> pessoa.getGenero().equalsIgnoreCase("masculino");


        List<Pessoa> homens = pessoas.stream()
                .filter(isMasculino)
                .collect(Collectors.toList());

        System.out.println("------------------- Gênero Masculino -------------------");
        homens.forEach(System.out::println);



        List<Pessoa> mulheres = pessoas.stream()
                .filter(isFeminino)
                .collect(Collectors.toList());
        System.out.println("------------------- Gênero Feminino -------------------");
        mulheres.forEach(System.out::println);

    }
}