package com.app.controllers;

import com.app.dto.InputPasswordDTO;
import com.app.dto.ResponseDTO;
import com.app.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/validate")
    @Operation(summary = "Valida um password através de um input")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna apenas 'true' ou 'false'", content = @Content)})
    public ResponseEntity<?> validatePassword(@RequestBody InputPasswordDTO dto){
        ResponseDTO response =  passwordService.validatePassword(dto.getInput());
        return new ResponseEntity<>(response.getOutput(), response.getStatus());
    }

}
