package br.com.carlosbrito.dao;

import br.com.carlosbrito.Contrato;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public interface IContratoDAO {
    void salvar(Contrato contrato);
    Contrato buscar(int id);

    void excluir(int id);

    void atualizar(Contrato contratoNovosDados);

    List<Contrato> listar();
}
