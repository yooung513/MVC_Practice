package org.example.Calculator.calculate;

public interface NewArithmeticOperator {
    boolean surpports(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
