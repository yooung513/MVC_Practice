package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "abcdefg";  // 7글자
    }
}
