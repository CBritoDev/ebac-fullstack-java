package Wildcards;

import fruta.Banana;
import fruta.Fruta;
import fruta.Maca;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
public class Wildcard {
    public static void main(String[] args){
        List<Long> listaLong =  new ArrayList<>();
        List<String> listaString = new ArrayList<>();
        listaLong.add(1l);
        listaString.add("ABACA-XI");

        imprimir(listaLong);
        imprimir(listaString);

        List<Fruta> frutas = new ArrayList<>();
        frutas.add(new Maca());
        frutas.add(new Banana());
        imprimirFrutas(frutas);
    }

    //Wildcard (?) super algumaClasse maior que fruta por exemplo
    public static void imprimirFrutas1(List<? super Fruta> lista){
//        for(Fruta fruta : lista){
//            System.out.println(fruta);
//        }
    }

    //Wildcard (?) extende outro tipo de objeto ex a seguir: <? extends Fruta(que é interface)>
    public static void imprimirFrutas(List<? extends Fruta> lista){
        for(Fruta fruta : lista){
            System.out.println(fruta);
        }
    }

    //Wildcard (?) é um objeto desconhecido.Tomar cuidado
    public static void imprimir(List<?> lista){
        for(Object st : lista){
            //posso descobrir o tipo de objeto e pedir algo especifico
            if(st instanceof  Long){
                Long stLong = (Long) st;
                System.out.println(st + " agora é um Long!");
            }else{
                System.out.println(st + " é um objeto qualquer!");
            }
        }
    }
}
