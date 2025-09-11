package com.studentapp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


public class NumberGuessServletTest {

    private NumberGuessServlet servlet;

    @Before
    public void setUp() {
        servlet = new NumberGuessServlet();
    }

    @Test
    public void testTargetNumberInRange() {
        int target = servlet.getTargetNumber(); // make sure this method exists in your servlet
        assertTrue("Target number should be between 1 and 100", target >= 1 && target <= 100);
    }

    @Test
    public void testGuessCorrectNumber() {
        int target = servlet.getTargetNumber();
        String result = servlet.checkGuess(target); // This should be a method in your servlet to check guesses
        assertEquals("Correct! You guessed the number.", result);
    }
}

