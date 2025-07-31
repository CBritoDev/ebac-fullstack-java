package br.com.carlosbrito;


import javax.swing.*;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
public class APPCliente {
    public static void main(String[] agrs){
        String opcao = JOptionPane.showInputDialog(null,
                "Digite o código do cliente","Cliente", JOptionPane.INFORMATION_MESSAGE);

        try{
            ClienteService.consultarCliente(opcao);
        }catch(ClienteNaoEncontrado2Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
