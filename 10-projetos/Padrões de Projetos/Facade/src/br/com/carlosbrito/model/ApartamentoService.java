package br.com.carlosbrito.model;

import br.com.carlosbrito.interfaces.IApartamentoService;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public class ApartamentoService implements IApartamentoService {
    @Override
    public Boolean cadastrarApartamento(Apartamento apartamento) {
        Boolean isCadastrado = isApartamentoCadastrado(apartamento);
        Boolean isCamposValidos = isCamposValidos(apartamento);
        if (isCadastrado && isCamposValidos){
            return false;
        }

        return cadastrarNoBanco(apartamento);
    }


    private boolean cadastrarNoBanco(Apartamento apartamento) {
        //logica de cadastro
        return true;
    }

    private Boolean isApartamentoCadastrado(Apartamento apartamento){
        //ir no bd e verificar o status do cadastro
        return false;
    }

    private Boolean isCamposValidos(Apartamento apartamento){
        return true;
    }


}
