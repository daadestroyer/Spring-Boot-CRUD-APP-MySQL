package com.daadestroyer.SpringBootCRUDAPP.exceptionhandling;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class APIResponse {
    private String message;
    private String status;
}
