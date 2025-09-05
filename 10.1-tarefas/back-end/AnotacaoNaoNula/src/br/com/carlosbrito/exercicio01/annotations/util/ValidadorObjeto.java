package br.com.carlosbrito.exercicio01.annotations.util;

import br.com.carlosbrito.exercicio01.annotations.NaoNulo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
public class ValidadorObjeto {

    public static <T> boolean validar(T objeto) throws InvocationTargetException, IllegalAccessException {
        Class objetoAnalizado = objeto.getClass();

        Field[] fields = objetoAnalizado.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NaoNulo.class)) {
                field.setAccessible(true);
                Object valorCampo = field.get(objeto);
                if(valorCampo == null){
                    System.out.println("Erro de validação: O campo '%s' não pode ser nulo.".formatted(field.getName())+ "\n");
                    return false;
                }
            }
        }
        System.out.println("Objeto validado com sucesso\n");
        return true;
    }
}
