package br.com.carlosbrito.reflections.cadastroReflaction.annotation;

import java.lang.annotation.*;

/**
 * @author carlos.brito
 * Criado em: 06/08/2025
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TipoChave {
    String value();
}
