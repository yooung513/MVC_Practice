package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 *  * 비밀번호 유효성 검증기 요구사항
 *  1. 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 *  2. 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생 시킨다.
 *  3. 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호는 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {

        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8지 미만 또는 12자 초과인 경우 IllegalArgumentException 에외가 발생한다.")
    @Test
    void validatePasswordTest2() {
        assertThatCode(() -> PasswordValidator.validate("aabb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 합니다.");
    }
    
}
