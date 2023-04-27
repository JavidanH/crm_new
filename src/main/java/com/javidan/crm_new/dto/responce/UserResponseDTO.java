package com.javidan.crm_new.dto.responce;

import com.javidan.crm_new.entity.OurUser;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private long id;
    private String name;
    private String surname;
    private String password;
    private String username;

    public static UserResponseDTO entityResponce(OurUser user) {

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .username(user.getUsername()).build();
    }
}
