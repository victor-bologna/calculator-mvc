package com.victor.service.impl;

import com.victor.model.CalculatorModel;
import com.victor.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String sum(CalculatorModel calculatorModel) {
        String valueA = calculatorModel.getValueA().replace(",", ".");
        String valueB = calculatorModel.getValueB().replace(",", ".");
        if(validateNumbers(valueA, valueB)) {
            return formatResult(Double.parseDouble(valueA) + Double.parseDouble(valueB));
        }
        return "Letras e caracteres especiais não são permitidos!";
    }

    @Override
    public String minus(CalculatorModel calculatorModel) {
        String valueA = calculatorModel.getValueA().replace(",", ".");
        String valueB = calculatorModel.getValueB().replace(",", ".");
        if(validateNumbers(valueA, valueB)) {
            return formatResult(Double.parseDouble(valueA) - Double.parseDouble(valueB));
        }
        return "Letras e caracteres especiais não são permitidos!";
    }

    private boolean validateNumbers(String valueA, String valueB) {
        String regex = "-?\\d+\\.?\\d*";
        return valueA.matches(regex) && valueB.matches(regex);
    }

    private String formatResult(Double result) {
        String resultText = "O resultado da operação é: ";
        String suffix = ".0";
        if(!result.toString().endsWith(suffix)) {
            return resultText + result;
        } else {
            return resultText + result.toString().replace(suffix, "");
        }
    }
}
