package com.studentapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NumberGuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int targetNumber;

    @Override
    public void init() throws ServletException {
        targetNumber = new Random().nextInt(100) + 1; // random number between 1 and 100
    }

    // Used by the test
    public int getTargetNumber() {
        return targetNumber;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Guess a number between 1 and 100</h2>");
        out.println("<form method='post'>");
        out.println("<input type='number' name='guess' min='1' max='100'/>");
        out.println("<input type='submit' value='Guess'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (guess == targetNumber) {
            out.print("Correct! You guessed the number.");
        } else if (guess < targetNumber) {
            out.print("Too low!");
        } else {
            out.print("Too high!");
        }
    }
}


