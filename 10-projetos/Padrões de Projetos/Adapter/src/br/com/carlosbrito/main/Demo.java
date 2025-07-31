package br.com.carlosbrito.main;

import br.com.carlosbrito.interfaces.Persistencia;
import br.com.carlosbrito.model.DropBox;
import br.com.carlosbrito.model.DropBoxAdapter;

import java.io.File;
import java.io.IOException;

/**
 * @author carlos.brito
 * Criado em: 23/07/2025
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String file = "teste.txt";
        DropBox dropBox = new DropBox();
        Persistencia arquivos = new DropBoxAdapter(dropBox);
        arquivos.gravarArquivo(new File(file));
    }
}
