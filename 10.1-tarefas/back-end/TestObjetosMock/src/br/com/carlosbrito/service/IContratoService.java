package br.com.carlosbrito.service;

import br.com.carlosbrito.Contrato;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public interface IContratoService {

    public String salvar(Contrato contrato);

    Contrato buscar(int id);

    void excluir(int i);

    void atualizar(Contrato contratoNovosDados);

    List<Contrato> listar();
}
