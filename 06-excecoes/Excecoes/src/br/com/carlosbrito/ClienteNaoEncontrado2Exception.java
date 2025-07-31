package br.com.carlosbrito;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
public class ClienteNaoEncontrado2Exception extends Exception {

    private Exception ex;

    public ClienteNaoEncontrado2Exception(String message, Throwable ex) {
        super(message,ex);
    }
}
