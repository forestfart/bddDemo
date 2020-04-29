package com.luxoft.javabdd.assertion;

import com.luxoft.javabdd.exception.NoJobException;
import com.luxoft.javabdd.exception.SystemUnderTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertThrowsExample {
    private final SystemUnderTest systemUnderTest = new SystemUnderTest();

    @Test
    void shouldRecognizeExpectedException() {
        assertThrows(NoJobException.class, systemUnderTest::getFirstJob);
    }

    @Test
    void shouldCatchException() {
        Throwable throwable = assertThrows(NoJobException.class, systemUnderTest::getFirstJob);

        assertEquals("Jobs list is empty.", throwable.getMessage());
    }
}


