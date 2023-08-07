package org.example.Password;

public class PasswordValidator {

    public static final String Wrong_Password_length_exception_message = "비밀번호는 최소 8자 이상 12자 이하여야 합니다.";

    public static void validate(String password){
        int length = password.length();

        if (length < 8 || length > 12){
            throw new IllegalArgumentException(Wrong_Password_length_exception_message);
        }
    }
}
