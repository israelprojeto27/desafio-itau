package com.app.controllers;

import com.app.builders.InputPasswordBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class PasswordControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Gson gson = new GsonBuilder().create();

    private static final String BASE_URL = "/password/validate";

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void shouldReturnTrueWhenInputValid() throws Exception {
        var dto = InputPasswordBuilder.buildInputValid();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(true, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsEmpty() throws Exception {
        var dto = InputPasswordBuilder.buildInputEmpty();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsNull() throws Exception {
        var dto = InputPasswordBuilder.buildInputNull();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneCharacter() throws Exception {
        var dto = InputPasswordBuilder.buildInputOneCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneDigit() throws Exception {
        var dto = InputPasswordBuilder.buildInputOneDigit();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneSpecialCharacter() throws Exception {
        var dto = InputPasswordBuilder.buildInputOneSpecialCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithSpecialCharacterInvalid() throws Exception {
        var dto = InputPasswordBuilder.buildInputSpecialCharacterInvalid();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenSizeInputIsLessThanNineCharacters() throws Exception {
        var dto = InputPasswordBuilder.buildInputSizeNineCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterUpperCase() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithoutOneCharacterUpperCase();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterLowerCase() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithoutOneCharacterLowerCase();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneDigit() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithoutOneDigit();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithoutOneSpecialCharacter() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithoutOneSpecialCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithSpaceBetween() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithSpaceBetween();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharacters() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateDigits() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateDigits();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateSpecialCharacters() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigits() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateCharactersAndDigits();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndSpecialCharacters() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateCharactersAndSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigitsSpecialCharacters() throws Exception {
        var dto = InputPasswordBuilder.buildInputWithDuplicateCharactersAndDigitsAndSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

}
