package br.com.carlosbrito.lambdas;

import java.util.function.IntBinaryOperator;

/**
 * @author carlos.brito
 * Criado em: 12/08/2025
 */
public class IntBinaryOperatorClass implements IntBinaryOperator {
    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
