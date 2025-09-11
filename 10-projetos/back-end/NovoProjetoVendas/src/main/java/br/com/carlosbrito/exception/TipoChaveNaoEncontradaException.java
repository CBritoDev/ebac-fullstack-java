package br.com.carlosbrito.exception;

/**
 * @author carlos.brito
 * Criado em: 10/09/2025
 */
public class TipoChaveNaoEncontradaException extends Exception {

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
