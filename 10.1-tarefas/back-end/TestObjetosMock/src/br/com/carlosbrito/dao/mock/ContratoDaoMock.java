package br.com.carlosbrito.dao.mock;

import br.com.carlosbrito.Contrato;
import br.com.carlosbrito.dao.IContratoDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 07/09/2025
 */
public class ContratoDaoMock implements IContratoDAO {

    private Map<Integer,Contrato> listaDeContratos = new HashMap<>();

    @Override
    public void salvar(Contrato contrato) {
        listaDeContratos.put(contrato.getId(), contrato);
    }

    @Override
    public Contrato buscar(int id) {
        Contrato contrato = listaDeContratos.get(id);
        return contrato;
    }

    @Override
    public void excluir(int id) {
        Contrato contrato = buscar(id);
        listaDeContratos.remove(contrato.getId());
    }

    @Override
    public void atualizar(Contrato contratoNovosDados) {
        listaDeContratos.put(contratoNovosDados.getId(),contratoNovosDados);
    }

    @Override
    public List<Contrato> listar() {
        List<Contrato> contratos = new ArrayList<>();
        contratos.addAll(listaDeContratos.values());
        return contratos;
    }


}
