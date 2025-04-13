public class PrimeiraClasse {

    public static void main(String args[]){
        Cliente cliente = new Cliente();
        cliente.cadastrarEndereco("Rua Um");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());
        //cliente.imprimirEndereco();
        System.out.println(cliente.retornarEnderecoCliente());
        System.out.println(cliente.getValorTotal());
    }
}
