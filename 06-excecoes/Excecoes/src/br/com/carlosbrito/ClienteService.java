package br.com.carlosbrito;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
public class ClienteService {
    public static void consultarCliente(String codigo) throws ClienteNaoEncontrado2Exception {

        try {
            ClienteDAO.consultarCliente(codigo);
        } catch (ClienteNaoEncontradoException e) {
            throw new ClienteNaoEncontrado2Exception(e.getMessage(),e);
        }
    }
}
