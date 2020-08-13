package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CalculatorController {


    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String getCalculatorPage(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return "Calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String getCalculatorPage(
            Model model,
            HttpServletRequest request,
            @RequestParam(value = "a")
                    int a,
            @RequestParam(value = "b")
                    int b,
            @RequestParam(value = "operation")
                    String operation,
            HttpServletResponse response
    ) {
        OperationModel operationModel = new OperationModel();

        operationModel.setA(a);
        operationModel.setB(b);
        operationModel.setOperation(operation);

        if(operation.equals("+")) {
            int c = calculatorService.calculatorAddition(operationModel);
            operationModel.setC(c);
        }

        if (operation.equals("-")) {
            int c = calculatorService.calculatorSubstraction(operationModel);
            operationModel.setC(c);
        }
        if(operation.equals("*")){
            int c = calculatorService.calculatorMultiplication(operationModel);
            operationModel.setC(c);
        }

        if(operation.equals("/")){
            double c = calculatorService.calculatorDivision(operationModel);
            operationModel.setC(c);
        }

        model.addAttribute("operationModel", operationModel);
        return "Calculator";

    }


}

