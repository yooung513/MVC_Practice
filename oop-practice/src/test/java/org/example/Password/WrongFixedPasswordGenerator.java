package org.example.Password;

import org.example.Password.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefg";  // 7글자
    }
}
