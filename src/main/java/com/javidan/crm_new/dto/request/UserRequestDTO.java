package com.javidan.crm_new.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequestDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String surname;

    private String password;

    private String username;
}
