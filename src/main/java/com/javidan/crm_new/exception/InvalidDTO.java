package com.javidan.crm_new.exception;

import com.javidan.crm_new.dto.responce.CommonResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class InvalidDTO extends RuntimeException{

    private CommonResponseDTO <?> responseDTO;

}
