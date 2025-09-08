package br.com.carlosbrito.dao;

import br.com.carlosbrito.Contrato;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public class ContratoDao implements IContratoDAO {
    @Override
    public void salvar(Contrato contrato) {
        throw new  UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public Contrato buscar(int id) {
        return null;
    }

    @Override
    public void excluir(int id) {

    }

    @Override
    public void atualizar(Contrato contratoNovosDados) {

    }

    @Override
    public List<Contrato> listar() {
        return List.of();
    }


}
