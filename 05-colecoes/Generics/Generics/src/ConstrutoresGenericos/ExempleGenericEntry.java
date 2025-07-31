package ConstrutoresGenericos;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
public class ExempleGenericEntry {
    public static void main(String[] args){
        GenericEntry<String,Long> entry = new GenericEntry<String,Long>("Teste", 2l,5l);
        System.out.println(entry.getData() + entry.getCodigo() + entry.getDesc());

        GenericEntry<Long, Integer> entryLong = new GenericEntry<Long,Integer>(2L,6l,24);
        System.out.println(entryLong.getData() + entryLong.getCodigo() + entryLong.getDesc());
    }
}
