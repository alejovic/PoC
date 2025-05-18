package com.avg.validator;

public class Main {

    public static void main(String[] args) {
        User user = new User("user@example.com", "password123");

        RegistrationService service = new RegistrationService(
                email -> email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"),
                pwd -> pwd != null && pwd.length() >= 8
        );

        service.register(user);
    }
}
