package com.sphere.nexus.controller;

import com.sphere.nexus.exception.DivisionByZeroException;
import com.sphere.nexus.exception.NoArgumentException;
import com.sphere.nexus.impl.CalculatorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    public CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String sayHello() {
        return calculatorService.sayHello();
    }

    @GetMapping("/plus")
    public String sum(@RequestParam(value = "num1", required = false) Integer num1,
                      @RequestParam(value = "num2", required = false) Integer num2) {
        try {
            return calculatorService.sum(num1, num2);
        } catch (NoArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/minus")
    public String subtraction(@RequestParam(value = "num1", required = false) Integer num1,
                              @RequestParam(value = "num2", required = false) Integer num2) {
        try {
            return calculatorService.subtraction(num1, num2);
        } catch (NoArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/multiply")
    public String multiplication(@RequestParam(value = "num1", required = false) Integer num1,
                                 @RequestParam(value = "num2", required = false) Integer num2) {
        try{
            return calculatorService.multiplication(num1, num2);
        } catch (NoArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/divide")
    public String division(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {
        try {
            return calculatorService.division(num1, num2);
        } catch (NoArgumentException | DivisionByZeroException e) {
            return e.getMessage();
        }
    }
}
