package br.com.carlosbrito.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @author carlos.brito
 * Criado em: 05/08/2025
 */
public class AppReflections {
    public static void main(String[] agrs) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Produto.class;
        System.out.println(clazz);

        Produto produto = new Produto();
        Class class1 = produto.getClass();
        System.out.println(class1);

        Constructor constructor = clazz.getConstructor();
        Produto produto1 = (Produto) constructor.newInstance();
        System.out.println(produto1);

        Field[] fields = produto1.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println("Campo: " + field.getName());
            System.out.println("Tipo:" + field.getType().getSimpleName());
        }

        Method[] methods = produto1.getClass().getDeclaredMethods();

        for(Method method : methods){
            System.out.println("Método: " + method.getName());
            System.out.println("Retorno: " + method.getReturnType().getSimpleName());
            System.out.println("Modificador:" + method.getModifiers() + "\n");

            if(method.getName().startsWith("get")){
                System.out.println(method.invoke(produto1));
            }else{
                for(Class types : method.getParameterTypes()){
                    if(types.equals(String.class)){
                        System.out.println(method.invoke(produto1, "Teste"));
                    }else if(types.equals(Long.class)){
                        System.out.println(method.invoke(produto1, 12L));
                    }else if(types.equals(Double.class)){
                        System.out.println(method.invoke(produto1, 24.0));
                    }
                }
            }
        }



    }
}
