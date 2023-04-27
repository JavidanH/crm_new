package com.javidan.crm_new.service;

import com.javidan.crm_new.dto.request.UserRequestDTO;
import com.javidan.crm_new.dto.responce.CommonResponseDTO;
import com.javidan.crm_new.dto.responce.Status;
import com.javidan.crm_new.dto.responce.StatusCode;
import com.javidan.crm_new.dto.responce.UserResponseDTO;
import com.javidan.crm_new.entity.OurUser;
import com.javidan.crm_new.exception.UserAlreadyExist;
import com.javidan.crm_new.repository.UserRepository;
import com.javidan.crm_new.util.DTOutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DTOutil dtOutil;

    @Autowired
    private UserRepository userRepository;

    public CommonResponseDTO<?> saveUser(UserRequestDTO userRequestDTO) {
        dtOutil.isValid((userRequestDTO));

        if (userRepository.findByUsername(userRequestDTO.getUsername()).isPresent()) {
            throw new UserAlreadyExist(CommonResponseDTO.builder().status(Status.builder()
                    .statusCode(StatusCode.USER_EXIST)
                    .message("USER ALREADY EXIST")
                    .build()).build());
        }


        OurUser user = OurUser.builder()
                .name(userRequestDTO.getName())
                .surname(userRequestDTO.getSurname())
                .password(userRequestDTO.getPassword())
                .username(userRequestDTO.getUsername())
                .role("Role_User").build();


        return CommonResponseDTO.builder().status(Status.builder()
                        .statusCode(StatusCode.SUCCES)
                        .message("User Created").build())
                .data(UserResponseDTO.entityResponce(userRepository.save(user)))
                .build();
    }

}
