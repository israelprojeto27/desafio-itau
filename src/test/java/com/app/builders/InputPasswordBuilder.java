package com.app.builders;

import com.app.dto.InputPasswordDTO;

public class InputPasswordBuilder {

    private static InputPasswordDTO dto = new InputPasswordDTO();

    public static InputPasswordDTO buildInputValid() {
        dto.setInput("Aa12@78b3E");
        return dto;
    }

    public static InputPasswordDTO buildInputEmpty() {
        dto.setInput("");
        return dto;
    }

    public static InputPasswordDTO buildInputNull() {
        dto.setInput(null);
        return dto;
    }

    public static InputPasswordDTO buildInputOneCharacter() {
        dto.setInput("a");
        return dto;
    }

    public static InputPasswordDTO buildInputOneDigit() {
        dto.setInput("1");
        return dto;
    }

    public static InputPasswordDTO buildInputOneSpecialCharacter() {
        dto.setInput("#");
        return dto;
    }

    public static InputPasswordDTO buildInputSpecialCharacterInvalid() {
        dto.setInput("Ab#c1469/p");
        return dto;
    }

    public static InputPasswordDTO buildInputSizeNineCharacters() {
        dto.setInput("Ab12#3oP");
        return dto;
    }

    public static InputPasswordDTO buildInputWithoutOneCharacterUpperCase() {
        dto.setInput("ab#c14dp34");
        return dto;
    }

    public static InputPasswordDTO buildInputWithoutOneCharacterLowerCase() {
        dto.setInput("AB#C14DP34");
        return dto;
    }

    public static InputPasswordDTO buildInputWithoutOneDigit() {
        dto.setInput("Ab#cdPeFhQ@");
        return dto;
    }

    public static InputPasswordDTO buildInputWithoutOneSpecialCharacter() {
        dto.setInput("Ab1cdPeFhQ2");
        return dto;
    }

    public static InputPasswordDTO buildInputWithSpaceBetween() {
        dto.setInput("Ab1# cdPeFhQ2");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateDigits() {
        dto.setInput("Ab1#cdPeFhQ21");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2#");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateCharactersAndDigits() {
        dto.setInput("Ab1#cdPeFhQ2A1");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateCharactersAndSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A#");
        return dto;
    }

    public static InputPasswordDTO buildInputWithDuplicateCharactersAndDigitsAndSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A1#");
        return dto;
    }






}
