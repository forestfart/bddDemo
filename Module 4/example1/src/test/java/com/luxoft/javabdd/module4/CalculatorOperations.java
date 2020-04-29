package com.luxoft.javabdd.module4;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorOperations {
    private Calculator calculator;
    private double sum;

    @Given("a calculator")
    public void a_calculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("you add <arg1> and <arg2>")
    public void you_add_and(int arg1, int arg2) throws Throwable {
        sum = calculator.add(arg1, arg2);
    }

    @Then("you obtain the sum <sum>")
    public void you_obtain_the_sum(int arg1) throws Throwable {
        assertEquals(arg1, sum);
    }
}
