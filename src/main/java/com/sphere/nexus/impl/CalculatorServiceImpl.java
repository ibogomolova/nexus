package com.sphere.nexus.impl;

import com.sphere.nexus.exception.DivisionByZeroException;
import com.sphere.nexus.exception.NoArgumentException;
import com.sphere.nexus.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String sayHello() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String sum(Integer num1, Integer num2) {
        checkArguments(num1, num2);
        return String.valueOf(num1 + num2);
    }

    @Override
    public String subtraction(Integer num1, Integer num2) {
        checkArguments(num1, num2);
        return String.valueOf(num1 - num2);
    }

    @Override
    public String multiplication(Integer num1, Integer num2) {
        checkArguments(num1, num2);
        return String.valueOf(num1 * num2);
    }

    @Override
    public String division(Integer num1, Integer num2) {
        checkArguments(num1, num2);
        divisionByZero(num2);
        return String.valueOf(num1 / num2);
    }

    private void checkArguments(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NoArgumentException("Не передан параметр");
        }
    }

    private void divisionByZero(Integer num2) {
        if (num2 == 0) {
            throw new DivisionByZeroException("Делить на ноль нельзя!");
        }
    }

}
