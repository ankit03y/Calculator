package com.example.calculator;
import com.example.calculator.CalculatorService;
import com.example.calculator.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

        OperationModel operationModel = new OperationModel();

        @Autowired
        private CalculatorService calculatorService;

        @RequestMapping("/calculator")
        public String getCalculatorPage(Model model){
            model.addAttribute("operationModel",operationModel);
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="add", method = RequestMethod.POST)
        public String add(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.add(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
        public String subtract(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.subtract(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="multiply", method = RequestMethod.POST)
        public String multiply(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.multiply(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="divide", method = RequestMethod.POST)
        public String divide(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.divide(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="fibonacci", method = RequestMethod.POST)
        public String fibonacci(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.fibonacci(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="sqrt", method = RequestMethod.POST)
        public String sqrt(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.sqrt(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="power", method = RequestMethod.POST)
        public String power(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.power(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="factorial", method = RequestMethod.POST)
        public String factorial(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("result", calculatorService.factorial(operationModel));
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
        public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("operationModel",  calculatorService.clearSimple(operationModel));
            model.addAttribute("result", 0);
            return "calculator";
        }

        @RequestMapping(value="/calculator", params="clearAdvanced", method = RequestMethod.POST)
        public String clearAdvanced(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
            model.addAttribute("operationModel",  calculatorService.clearAdvanced(operationModel));
            model.addAttribute("result", 0);
            return "calculator";
        }
}

