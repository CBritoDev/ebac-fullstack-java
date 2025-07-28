package br.com.carlosbrito.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class Garagem<T extends Carro>{
    private List<T> carros =  new ArrayList<>();

    public void adicionarCarro(T carro){
        carros.add(carro);
    }

    public void listarCarros(){
        for(T carro: carros){
            carro.exibirDetalhes();
        }
    }
}
