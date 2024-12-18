package com.example.sample_app.user;

import lombok.*;

@With
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements java.io.Serializable {

    private Long identifier;

    private String name;

    private String role;
}
