package br.com.carlosbrito.anotacao;

import java.lang.annotation.*;

/**
 * @author carlos.brito
 * Criado em: 29/07/2025
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface PrimeiraAnotacao {
    String value();

    String[] bairros();

    long numeroCasa();

    double valores()  default 10d;
}
