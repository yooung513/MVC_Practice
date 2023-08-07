package org.example.Password;

import org.example.Password.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh";  // 8글자
    }
}
