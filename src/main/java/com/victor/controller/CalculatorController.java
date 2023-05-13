package com.victor.controller;

import com.victor.model.CalculatorModel;
import com.victor.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

    private final CalculatorModel calculatorModel = new CalculatorModel();

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("calculatorModel", calculatorModel);
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="sum", method = RequestMethod.POST)
    public String sum(@ModelAttribute("calculatorModel") CalculatorModel calculatorModel, Model model){
        model.addAttribute("result", calculatorService.sum(calculatorModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="minus", method = RequestMethod.POST)
    public String minus(@ModelAttribute("calculatorModel") CalculatorModel calculatorModel, Model model){
        model.addAttribute("result", calculatorService.minus(calculatorModel));
        return "calculator";
    }
}
