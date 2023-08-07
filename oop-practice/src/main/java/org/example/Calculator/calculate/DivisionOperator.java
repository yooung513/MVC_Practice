package org.example.Calculator.calculate;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean surpports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        if (operand2.toInt() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return operand1.toInt() / operand2.toInt();
    }
}
