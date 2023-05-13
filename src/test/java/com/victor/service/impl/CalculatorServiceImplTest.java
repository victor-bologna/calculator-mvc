package com.victor.service.impl;

import com.victor.model.CalculatorModel;
import com.victor.service.CalculatorService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Test
    void sumSuccess() {
        String result = calculatorService.sum(new CalculatorModel("1", "2"));

        BDDAssertions.then(result).isEqualTo("O resultado da operação é: 3");
    }

    @Test
    void sumWrongType() {
        String result = calculatorService.sum(new CalculatorModel("a", "2"));

        BDDAssertions.then(result).isEqualTo("Letras e caracteres especiais não são permitidos!");
    }

    @Test
    void minusSuccess() {
        String result = calculatorService.minus(new CalculatorModel("3", "2"));

        BDDAssertions.then(result).isEqualTo("O resultado da operação é: 1");
    }

    @Test
    void minusWrongType() {
        String result = calculatorService.minus(new CalculatorModel("a", "2"));

        BDDAssertions.then(result).isEqualTo("Letras e caracteres especiais não são permitidos!");
    }
}
