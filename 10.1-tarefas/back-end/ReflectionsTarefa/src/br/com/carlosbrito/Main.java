package br.com.carlosbrito;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Class classExemplo  = TabelaExercicio.class;

        Field[] fields = classExemplo.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Tabela.class)){
                Tabela tabelaAnotacao =  field.getAnnotation(Tabela.class);
                System.out.println(tabelaAnotacao.value());
            }
        }
    }
}