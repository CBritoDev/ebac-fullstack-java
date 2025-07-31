package br.com.carlosbrito.main;

import br.com.carlosbrito.interfaces.IApartamentoService;
import br.com.carlosbrito.model.Apartamento;
import br.com.carlosbrito.model.ApartamentoService;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IApartamentoService service = new ApartamentoService();
        service.cadastrarApartamento(new Apartamento(1L, "Endereço"));
    }
}