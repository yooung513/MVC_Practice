package org.example.Calculator.calculate;

public class AdditionOperator implements NewArithmeticOperator{

    @Override
    public boolean surpports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();
    }
}
