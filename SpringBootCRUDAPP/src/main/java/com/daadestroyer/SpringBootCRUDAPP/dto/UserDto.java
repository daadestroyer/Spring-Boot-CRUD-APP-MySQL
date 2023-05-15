package com.daadestroyer.SpringBootCRUDAPP.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @Null
    private Long userId;
    @NotEmpty(message = "please enter first name")
    @Size(min = 5 , message = "name can not be less than 5 letters")
    private String firstName;
    @NotEmpty(message = "please enter last name")
    private String lastName;
    @NotEmpty(message = "plese enter email")
    @Email
    private String email;
}
