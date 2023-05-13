package com.victor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victor.model.CalculatorModel;
import com.victor.service.CalculatorService;
import com.victor.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCalculatorPage() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attributeExists("calculatorModel"))
                .andReturn().getResponse();

        String result = response.getContentAsString();

        then(result).isNotEmpty();
    }

    @Test
    void sum() throws Exception {
        CalculatorModel calculatorModel = new CalculatorModel("1", "2");

        given(calculatorService.sum(calculatorModel)).willReturn("O resultado da operação é: 1");

        MockHttpServletResponse response = mockMvc.perform(post("/calculator")
                        .param("sum", "1", "2")
                        .flashAttr("calculatorModel", calculatorModel))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        String result = response.getContentAsString();

        verify(calculatorService).sum(calculatorModel);

        then(result).isNotEmpty();
    }

    @Test
    void minus() throws Exception {
        CalculatorModel calculatorModel = new CalculatorModel("3", "2");

        given(calculatorService.minus(calculatorModel)).willReturn("O resultado da operação é: 1");

        MockHttpServletResponse response = mockMvc.perform(post("/calculator")
                        .param("minus", "3", "2")
                        .flashAttr("calculatorModel", calculatorModel))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        String result = response.getContentAsString();

        verify(calculatorService).minus(calculatorModel);

        then(result).isNotEmpty();
    }
}