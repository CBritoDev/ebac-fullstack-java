package br.com.carlosbrito.dao;

import br.com.carlosbrito.generics.GenericDAO;
import br.com.carlosbrito.domain.Cliente;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
