public class FirstClass {

    public static void main(String args[]) {

        Carro carro1 = new Carro();

        carro1.setValorDoCarro(150.000);
        carro1.setAnoLancamento(2024);
        carro1.setMarcaCarro("OBO Cars");
        carro1.setIdDoCarro(21245);

        carro1.mostraInfoCarro();
        carro1.mensagem("Olá");

    }

}
