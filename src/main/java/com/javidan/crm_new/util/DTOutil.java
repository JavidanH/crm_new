package com.javidan.crm_new.util;

import com.javidan.crm_new.dto.request.UserRequestDTO;
import com.javidan.crm_new.dto.responce.CommonResponseDTO;
import com.javidan.crm_new.dto.responce.Status;
import com.javidan.crm_new.dto.responce.StatusCode;
import com.javidan.crm_new.exception.InvalidDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DTOutil {
    @Autowired
    private Logger logger;

    public void isValid (UserRequestDTO userRequestDTO) {
        logger.warn(userRequestDTO.toString());
        checkDTOInputInfo(userRequestDTO.getSurname());
        checkDTOInputInfo(userRequestDTO.getName());
        checkDTOInputInfo(userRequestDTO.getPassword());
        checkDTOInputInfo((userRequestDTO.getUsername()));
    }

    private <T> void checkDTOInputInfo(T t) {
        if (Objects.isNull(t) || t.toString().isBlank()) {
            logger.error("Invalid Input");
            throw InvalidDTO.builder().responseDTO(CommonResponseDTO.builder()
                    .status(Status.builder().
                            statusCode(StatusCode.INVALID_DTO)
                            .message("Invalid data")
                            .build())
                    .build()).build();
        }
    }
}
