package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    PasswordValidator passwordValidator;

    public ResponseDTO validatePassword(String input){

        ResponseDTO responseValid = ResponseDTO.from(true, HttpStatus.OK);
        ResponseDTO responseInvalid = ResponseDTO.from(false, HttpStatus.OK);

        if (!passwordValidator.isValidSize(input)){
            return responseInvalid;
        }

        if (passwordValidator.containsSpace(input)){
            return responseInvalid;
        }

        if (!passwordValidator.containsOneDigit(input)){
            return responseInvalid;
        }

        if (!passwordValidator.containsOneCharUpper(input)){
            return responseInvalid;
        }

        if (!passwordValidator.containsOneCharLower(input)){
            return responseInvalid;
        }

        if (!passwordValidator.containsOneSpecialCharacter(input)){
            return responseInvalid;
        }

        if (!passwordValidator.containsSpecialCharacterInvalid(input)){
            return responseInvalid;
        }

        if (passwordValidator.containsDuplicateCharacter(input)){
            return responseInvalid;
        }
        return responseValid;
    }

    public boolean isValid(){
        return true;
    }
}
