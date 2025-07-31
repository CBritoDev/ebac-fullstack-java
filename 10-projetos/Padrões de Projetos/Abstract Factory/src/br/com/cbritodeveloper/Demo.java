package br.com.cbritodeveloper;

/**
 * @author carlos.brito
 * Criado em: 08/07/2025
 */
public class Demo {
    public static void main(String[] args){
        Customer client = new Customer("A", false);
        Factory factory = getFactory(client);
        Car car = factory.create(client.getGradeRequest());
    }

    private static Factory getFactory(Customer client) {
        if(client.hasCompanyContract()){
            return  new ContractFactory();
        }else{
            return new NoContractFactory();
        }
    }
}
