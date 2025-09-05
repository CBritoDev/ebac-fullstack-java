package br.com.carlosbrito.exercicio02.model;

import java.lang.reflect.Field;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
public class InspetorDeObjeto {
    public static <T> void inspecionar(T objeto) throws IllegalAccessException {
        Class objetoInspecionado = objeto.getClass();

        Field[] fields = objetoInspecionado.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            Object campoInspecionado = field.get(objeto);
            System.out.println("Campo: " + field.getName().toUpperCase() + "\nValor: "+ campoInspecionado +"\n");
        }
    }
}
