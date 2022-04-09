package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.validators.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class PasswordServiceTest {

    @InjectMocks
    PasswordService passwordService;

    @InjectMocks
    PasswordValidator passwordValidator;

    @BeforeEach
    void setup(){
        passwordService.passwordValidator = passwordValidator;
    }


    @Test
    void shouldReturnTrueWhenInputIsValid(){
        final ResponseDTO response = passwordService.validatePassword("Abc@12#3Pd");
        Assertions.assertEquals(true, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputIsEmpty(){
        final ResponseDTO response = passwordService.validatePassword("");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsNull(){
        final ResponseDTO response = passwordService.validatePassword(null);
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsOneCharacter(){
        final ResponseDTO response = passwordService.validatePassword("a");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenSizeInputIsLessThanNineCharacters(){
        final ResponseDTO response = passwordService.validatePassword("Ab#c14");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenSizeInputWithSpecialCharacterInvalid(){
        final ResponseDTO response = passwordService.validatePassword("Ab#c1469/p");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterUpperCase(){
        final ResponseDTO response = passwordService.validatePassword("ab#c14dp34");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterLowerCase(){
        final ResponseDTO response = passwordService.validatePassword("AB#c14DP34");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneDigit(){
        final ResponseDTO response = passwordService.validatePassword("Aa#cefdP@p");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneSpecialCharacter(){
        final ResponseDTO response = passwordService.validatePassword("Aa1cefdP2p");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithSpaceBetween(){
        final ResponseDTO response = passwordService.validatePassword("Aa1# @fdP2p");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharacters(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2pA");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateDigits(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2p2");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateSpecialCharacters(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2p@");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigits(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2pA1");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndSpecialCharacters(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2pA@");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigitsSpecialCharacters(){
        final ResponseDTO response = passwordService.validatePassword("Aa1#@fdP2pA@1");
        Assertions.assertEquals(false, response.getOutput());
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
    }
}
