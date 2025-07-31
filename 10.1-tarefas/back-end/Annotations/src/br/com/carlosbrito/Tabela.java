package br.com.carlosbrito;

import java.lang.annotation.*;

/**
 * @author carlos.brito
 * Criado em: 31/07/2025
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Tabela {
    String nome();
}
