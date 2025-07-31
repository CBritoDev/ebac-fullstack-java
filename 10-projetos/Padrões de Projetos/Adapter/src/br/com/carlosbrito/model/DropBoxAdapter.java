package br.com.carlosbrito.model;

import br.com.carlosbrito.interfaces.Persistencia;

import java.io.File;

/**
 * @author carlos.brito
 * Criado em: 23/07/2025
 */
public class DropBoxAdapter implements Persistencia {

    private DropBox dropBox;

    public DropBoxAdapter(DropBox dropBox){
        this.dropBox = dropBox;
    }

    @Override
    public void gravarArquivo(File file) {
        dropBox.upload(new DropBoxFile(file.getAbsolutePath()));
    }

    @Override
    public File lerArquivo(String caminho) {
        DropBoxFile file = dropBox.download(caminho);
        return new File(file.getLocalPath());
    }
}
