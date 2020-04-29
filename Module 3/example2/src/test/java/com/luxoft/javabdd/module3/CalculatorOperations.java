package com.luxoft.javabdd.module3;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorOperations {
    private Calculator calculator;
    private double sum;

    @Given("^a calculator$")
    public void a_calculator_with_an_examples_table() throws Throwable {
        calculator = new Calculator();
    }

    @When("^you add (\\d+) and (\\d+)$")
    public void you_add_arguments_and(int arg1, int arg2) throws Throwable {
        sum = calculator.add(arg1, arg2);
    }

    @Then("^you obtain the sum (\\d+)$")
    public void you_obtain_the_result(int arg1) throws Throwable {
        assertEquals(arg1, sum);
    }
}
