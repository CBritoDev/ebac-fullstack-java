package br.com.carlosbrito.reflections.cadastroReflaction.dao;

import br.com.carlosbrito.reflections.cadastroReflaction.dao.generic.GenericDAO;
import br.com.carlosbrito.reflections.cadastroReflaction.domain.Cliente;

/**
 * @author carlos.brito
 * Criado em: 19/06/2025
 */
public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO{



    public ClienteMapDAO(){
        super();
    }
    // Chama o construtor da classe pai (GenericDAO)
    // Este construtor de GenericDAO faz o seguinte:
    // 1. Inicializa o 'map' aninhado para esta instância de ClienteMapDAO.
    // 2. Garante que um 'innerMap' (HashMap<Long, Cliente>) seja criado e
    //    adicionado ao 'map' principal, usando 'Cliente.class' como chave.


    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setTel(entity.getTel());
        entityCadastrado.setEndereco(entity.getEndereco());

    }

    // Este é o ÚNICO metodo abstrato que a ClienteMapDAO precisa implementar de GenericDAO.
    // Ele informa ao GenericDAO qual é o tipo concreto de 'T' para esta implementação.
    @Override
    public Class<Cliente> getClassType() {
        return Cliente.class;
    }


}
