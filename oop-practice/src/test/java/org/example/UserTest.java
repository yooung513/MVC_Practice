package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("패스워드 초기화한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when -> 랜덤 비밀번호 생성을 제어하기 위해 인터페이스 선언 (실제 운영에서 사용)
        user.initPassword(new RandomPasswordGenerator());

        //then -> 테스트코드가 비밀번호를 랜덤으로 만들기 때문에 실패/성공이 나타난다.
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합해 초기화된다.")
    @Test
    void passwordTest1() {
        //given
        User user = new User();

        //when -> 패스워드가 요구사항에 부합
//        user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdefgh");    //functional interface

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when -> 패스워드가 요구사항에 부합하지 않는다.
//        user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "ab");

        //then
        assertThat(user.getPassword()).isNull();
    }
}