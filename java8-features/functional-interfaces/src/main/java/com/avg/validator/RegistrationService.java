package com.avg.validator;

import java.util.function.Predicate;

public class RegistrationService {

    private final Predicate<String> emailValidator;
    private final Predicate<String> passwordValidator;

    public RegistrationService(Predicate<String> emailValidator,
                               Predicate<String> passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public void register(User user) {
        if (!emailValidator.test(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!passwordValidator.test(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        System.out.println("✅ User registered successfully: " + user.getEmail());
    }
}
