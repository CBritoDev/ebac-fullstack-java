package MetodosGenericos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MetodosGenericos {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Pedro");
        lista.add("1");

        imprimir(lista);

        List<Long> listaLong = new ArrayList<>();
        listaLong.add(20L);
        listaLong.add(2l);

        imprimir(listaLong);
        System.out.println(pegarPrimeiroListaLong(listaLong));
        System.out.println(pegarPrimeiroLista(lista));

    }

    //Metodo generico que vai receber algo generico e imprime esse algo generico, 
    // pode receber qualquer objeto
    public static <T> void imprimir(List<T> lista){
        for(T st : lista){
            System.out.println(st);
        }
    }
    //recebe algo generico e retorna algo generico
    public static <T> T pegarPrimeiroLista(List<T> lista){
        return lista.getFirst();
    }

    //recebe algo generico e retorna algo especifico
    public static <T> Long pegarPrimeiroListaLong(List<T> lista){
        return (Long) lista.getFirst();
    }

}