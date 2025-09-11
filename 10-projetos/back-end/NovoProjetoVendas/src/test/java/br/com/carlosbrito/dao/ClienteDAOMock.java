package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.generics.GenericDAO;


/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class ClienteDAOMock extends GenericDAO<Cliente> implements IClienteDAO{

    public ClienteDAOMock(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
