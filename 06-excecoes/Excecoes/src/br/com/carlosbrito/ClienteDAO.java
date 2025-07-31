package br.com.carlosbrito;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
public class ClienteDAO {


    public static void consultarCliente(String codigo) throws ClienteNaoEncontradoException {
        //busca no bando
        boolean isCadastrado = false;

        if(!isCadastrado){
            throw new ClienteNaoEncontradoException("Cliente não foi encontrado");
        }
    }
}
