package br.com.carlosbrito.model;

import br.com.carlosbrito.interfaces.Persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author carlos.brito
 * Criado em: 23/07/2025
 */
public class GoogleDriveAdapter implements Persistencia {
    GoogleDrive googleDrive;

    public GoogleDriveAdapter(GoogleDrive googleDrive){
        this.googleDrive = googleDrive;
    }

    @Override
    public void gravarArquivo(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());
        googleDrive.send(bytes, "arquivo.txt");
    }

    @Override
    public File lerArquivo(String caminho) {
        caminho = "arquivo.txt";
        return new File(String.valueOf(googleDrive.get(caminho)));
    }
}
