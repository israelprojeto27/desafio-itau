package com.app.validators;

import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.app.utils.Constants.MIN_SIZE_CHARS_PASSWORD;
import static com.app.utils.Constants.SPECIAL_CHARACTERS_VALID;


@Component
public class PasswordValidator {

    public boolean isValidSize(String input){
        if (input == null) {
            return false;
        } else if ( input != null && input.trim().equals("")){
            return false;
        } else if ( input.trim().length() < MIN_SIZE_CHARS_PASSWORD){
            return false;
        }
        return true;
    }

    public boolean containsSpace(String input){
        if (input.contains(" ")){
            return true;
        } else {
            return false;
        }
    }

    public boolean containsOneDigit(String input){
        return input.chars()
                .filter(e -> Character.isDigit(e))
                .findFirst()
                .isPresent();
    }

    public boolean containsOneCharUpper(String input){
        return input.chars()
                .filter(e -> Character.isUpperCase(e))
                .findFirst()
                .isPresent();
    }

    public boolean containsOneCharLower(String input){
        return input.chars()
                .filter(e -> Character.isLowerCase(e))
                .findFirst()
                .isPresent();
    }

    public boolean containsOneSpecialCharacter(String input){
        char[] arrayChar = input.toCharArray();
        for (char c : arrayChar){
            if ( SPECIAL_CHARACTERS_VALID.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }

    public boolean containsSpecialCharacterInvalid(String input){
        char[] arrayChar = input.toCharArray();
        for (char c : arrayChar){
            if (! Character.isAlphabetic(c) &&
                ! Character.isDigit(c) &&
                ! SPECIAL_CHARACTERS_VALID.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }

    public boolean containsDuplicateCharacter(String input){
        HashMap<String, String> map = new HashMap<>();
        char[] arrayChar = input.toCharArray();
        for (char c : arrayChar){
            if ( existsCharacterInMap(map, c)){
                return true;
            }
        }
        return false;
    }

    private boolean existsCharacterInMap(HashMap<String, String> map, char c) {
        if ( map.containsKey(String.valueOf(c))){
            return true;
        } else {
            map.put(String.valueOf(c), String.valueOf(c));
            return false;
        }
    }

}
