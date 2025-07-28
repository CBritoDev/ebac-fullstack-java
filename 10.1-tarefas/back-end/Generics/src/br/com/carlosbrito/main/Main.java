package br.com.carlosbrito.main;

import br.com.carlosbrito.models.Carro;
import br.com.carlosbrito.models.CarroSUV;
import br.com.carlosbrito.models.CarroSedan;
import br.com.carlosbrito.models.Garagem;

import java.util.ArrayList;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Garagem<Carro> minhaGaragem = new Garagem<>();

        Carro carroSedan =  new CarroSedan("Sedan");
        Carro carroSuv = new CarroSUV("Suv");

        minhaGaragem.adicionarCarro(carroSedan);
        minhaGaragem.adicionarCarro(carroSuv);

        minhaGaragem.listarCarros();
    }
}