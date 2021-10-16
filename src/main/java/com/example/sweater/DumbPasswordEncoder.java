package com.example.sweater;

import org.springframework.security.crypto.password.PasswordEncoder;

public class DumbPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return String.format("secret: '%s'", rawPassword);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
