package br.com.carlosbrito.anotation;

import java.lang.annotation.*;

/**
 * @author carlos.brito
 * Criado em: 10/09/2025
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}