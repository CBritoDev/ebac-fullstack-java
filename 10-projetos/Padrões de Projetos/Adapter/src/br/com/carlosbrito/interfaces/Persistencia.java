package br.com.carlosbrito.interfaces;

import java.io.File;
import java.io.IOException;

/**
 * @author carlos.brito
 * Criado em: 23/07/2025
 */
public interface Persistencia {
    public void gravarArquivo(File file) throws IOException;

    public File lerArquivo(String caminho);
}
