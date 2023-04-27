package com.javidan.crm_new.exception;

import com.javidan.crm_new.dto.responce.CommonResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAlreadyExist extends RuntimeException {
    private final CommonResponseDTO<?> responseDTO;
}
