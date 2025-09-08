package br.com.carlosbrito.service;

import br.com.carlosbrito.Contrato;
import br.com.carlosbrito.dao.IContratoDAO;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public class ContratoService implements IContratoService {

    private IContratoDAO contratoDao;

    public ContratoService(IContratoDAO dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar(Contrato contrato) {
        contratoDao.salvar(contrato);
        return "Sucesso";
    }

    @Override
    public Contrato buscar(int id) {
        Contrato contrato = contratoDao.buscar(id);
        return contrato;
    }

    @Override
    public void excluir(int id) {
        Contrato contrato = buscar(id);
        contratoDao.excluir(contrato.getId());
    }

    @Override
    public void atualizar(Contrato contratoNovosDados) {
        contratoDao.atualizar(contratoNovosDados);
    }

    @Override
    public List<Contrato> listar() {
        return contratoDao.listar();
    }
}
