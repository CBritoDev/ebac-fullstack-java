package br.com.carlosbrito;

import java.lang.annotation.*;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Tabela {
    String value();
}
