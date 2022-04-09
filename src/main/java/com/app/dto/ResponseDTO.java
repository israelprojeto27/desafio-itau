package com.app.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseDTO {
    private Boolean output;
    private HttpStatus status;

    public static ResponseDTO from (Boolean output, HttpStatus status){
        return ResponseDTO.builder()
                .output(output)
                .status(status)
                .build();
    }
}
