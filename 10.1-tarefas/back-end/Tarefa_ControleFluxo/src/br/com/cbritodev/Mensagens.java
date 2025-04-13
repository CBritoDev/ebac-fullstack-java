package br.com.cbritodev;

public class Mensagens {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String printNow(String mensagem){
        System.out.println(mensagem);
        return mensagem;
    }
}
