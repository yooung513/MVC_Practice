package org.example.Calculator;

import org.example.Calculator.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * - 요구사항
 * 1. 간단한 사칙연산을 할 수 있다.
 * 2. 양수로만 계산할 수 있다.
 * 3. 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * 4. MVC (Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+", 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺼셈 연산을 수행한다.")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(1, "-", 2);

        assertThat(result).isEqualTo(-1);

    }

    @DisplayName("하나의 테스트 메소드 구현")
    @ParameterizedTest
    @MethodSource("formularAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {

        // enum
//        int calculateResult = Calculator.enumCalculate(operand1, operator, operand2);

        // interface
        int calculateResult = Calculator.interfaceCalculate(new PositiveNumber(operand1),
                                                            operator,
                                                            new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formularAndResult() {
        return Stream.of(

                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)

        );
    }


    // 양수만 전달하므로 해당 부분은 의미가 없어짐
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateException() {
        assertThatCode(() -> Calculator.interfaceCalculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");

    }

}
