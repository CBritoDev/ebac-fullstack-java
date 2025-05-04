import br.com.cbritodev.abstratas.Assalariado;
import br.com.cbritodev.abstratas.Comissionado;
import br.com.cbritodev.abstratas.Empregado;
import br.com.cbritodev.abstratas.Horista;


public class Main {
    public static void main(String[] args) {
        Assalariado empregado = new Assalariado();
        empregado.setCpf("1");
        empregado.setNome("Carlos");
        empregado.setSobrenome("Brito");
        empregado.setSalario(5700.98d);
        imprimir(empregado);

        Comissionado comissionado = new Comissionado();
        comissionado.setCpf("2");
        comissionado.setNome("Carlos");
        comissionado.setSobrenome("Brito");
        comissionado.setTotalVenda(4700d);
        comissionado.setTotalComissao(0.1d);
        imprimir(comissionado);


        Horista horista = new Horista();
        horista.setCpf("3");
        horista.setNome("Carlos");
        horista.setSobrenome("Brito");
        horista.setPrecoHora(400d);
        horista.setTotaHoraTrabalhada(60d);
        imprimir(horista);

    }

    public static void imprimir(Empregado empregado) {
        if(empregado instanceof Horista) {
            Horista hor = (Horista) empregado;
            System.out.println(hor.getPrecoHora());
        }
        empregado.imprimirValores();
        empregado.imprimirSobrenome();
        System.out.println(empregado.getNome() + " " + empregado.getSobrenome() + " tem de salário: " + empregado.vencimento());
    }
}