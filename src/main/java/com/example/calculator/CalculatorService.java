package com.example.calculator;

import com.example.calculator.OperationModel;
import org.springframework.stereotype.Service;
import java.lang.Math;

@Service
public class CalculatorService {

        public int calculatorAddition(OperationModel model){
            int c = model.getA() + model.getB();
            return c;
        }

        public int calculatorSubstraction(OperationModel model){
           int c = model.getA() - model.getB();
           return c;
        }

        public int calculatorMultiplication(OperationModel model){
            int c = model.getA() * model.getB();
            return c;
        }

        public double calculatorDivision(OperationModel model){
            if(model.getA() == 0) return 0;
            if(model.getB() == 0) return 0;
            double c = model.getA() / model.getB();
            return c;
        }

}
