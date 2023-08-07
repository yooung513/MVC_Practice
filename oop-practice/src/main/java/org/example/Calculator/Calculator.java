package org.example.Calculator;

import org.example.Calculator.calculate.*;

import java.util.List;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {

        // 기존 사칙연산
        if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if ("-".equals(operator)) {
            return operand1 - operand2;
        } else if ("*".equals(operator)) {
            return operand1 * operand2;
        } else if ("/".equals(operator)) {
            return operand1 / operand2;
        }
        return 0;

    }


    // 리팩토링 (1) : Enum 방식
    public static int enumCalculate(int operand1, String operator, int operand2){

        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }


    // 리팩토링 (2) : Interface 사용 방식
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
                                                                                  new SubtractionOperator(),
                                                                                  new MultiplicationOperator(),
                                                                                  new DivisionOperator());

    public static int interfaceCalculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.surpports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
