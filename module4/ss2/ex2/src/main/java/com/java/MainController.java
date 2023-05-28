package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMainCalculator(@ModelAttribute("calculator") CalculatorObject calculator, Model model){
        String result = "";
        if (calculator != null){
            result = countCalculation(calculator.getFirstNum(),
                    calculator.getSecondNum(), calculator.getCalculation());
        }
        if (calculator == null){
            calculator = new CalculatorObject();
        }
        model.addAttribute("calculator", calculator);
        model.addAttribute("result",result);
        return "index";
    }

    private String countCalculation(int firstNum, int secondNum, String calculation) {
        switch (calculation){
            case "add":
                return String.valueOf(firstNum + secondNum);
            case "sub":
                return String.valueOf(firstNum - secondNum);
            case "mul":
                return String.valueOf(firstNum * secondNum);
            case "div":
                if (secondNum == 0)
                    return "Can't calculator!";
                return String.valueOf(firstNum / secondNum);
            default:
                return "Error!";

        }

    }

}
