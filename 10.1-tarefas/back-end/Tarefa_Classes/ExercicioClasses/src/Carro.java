public class Carro {

    private int idDoCarro;
    private String marcaCarro;
    private int anoLancamento;
    private double valorDoCarro;

    public int getIdDoCarro() {
        return idDoCarro;
    }

    public void setIdDoCarro(int idDoCarro) {
        this.idDoCarro = idDoCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getValorDoCarro() {
        return valorDoCarro;
    }

    public void setValorDoCarro(double valorDoCarro) {
        this.valorDoCarro = valorDoCarro;
    }


    /**
     * Mostra as informações do carro no terminal
     *
     * @since Version1
     */
    public void mostraInfoCarro(){
        System.out.println(this.marcaCarro);
        System.out.println(this.valorDoCarro);
        System.out.println(this.idDoCarro);
        System.out.println(this.anoLancamento);
    }
    public String mensagem(String mensagem){
        System.out.print(mensagem);
        return mensagem;
    }

}
