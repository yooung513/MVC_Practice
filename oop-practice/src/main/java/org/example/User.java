package org.example;

public class User {
    private String password;

    // 패스워드 초기화
    public void initPassword(PasswordGenerator passwordGenerator) {    // 랜덤으로 패스워드 초기화 -> 컨트롤하기 위해 인터페이스 생

        // as-is 방식 (강한 결합)
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
//        String password = randomPasswordGenerator.generatePassword();

        // to-be 방식 (약한 결합 -> 인터페이스 사용)
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
