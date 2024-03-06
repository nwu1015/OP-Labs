package com.example.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/calculator")
public class Сalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String startStr = request.getParameter("start");
            String endStr = request.getParameter("end");
            String stepStr = request.getParameter("step");

            double start = Double.parseDouble(startStr);
            double end = Double.parseDouble(endStr);
            double step = Double.parseDouble(stepStr);

            List<Double[]> results = new ArrayList<>();
            for (double i = start; i <= end; i += step) {
                double first = i;
                double second = i;
                double third = i;
                double fourth = i;

                double result1 = 3 * (Math.log(Math.abs(first / second))) + Math.sqrt(Math.cos(third) + Math.exp(fourth));
                double result2 = 6 * Math.sin(Math.abs(2 * first)) * Math.log(second) + Math.sqrt(third * Math.cosh(-1 * fourth));
                double result3 = Math.pow(2 * Math.sin(first) + Math.cos(Math.abs(second)) * Math.sqrt(third), fourth);

                Double[] resultsRow = {first, second, third, fourth, result1, result2, result3};
                results.add(resultsRow);
            }

            // Збереження результатів у сесії
            request.getSession().setAttribute("results", results);

            // Встановлення кукі
            Cookie startCookie = new Cookie("start", startStr);
            Cookie endCookie = new Cookie("end", endStr);
            Cookie stepCookie = new Cookie("step", stepStr);
            response.addCookie(startCookie);
            response.addCookie(endCookie);
            response.addCookie(stepCookie);

            // Перенаправлення на JSP-сторінку
            response.sendRedirect("index.jsp");

        } catch (NumberFormatException e) {
            // Збереження повідомлення про помилку у сесії
            request.getSession().setAttribute("errorMessage", "Неправильні дані. Будь ласка, введіть дійсні числа.");

            // Перенаправлення на JSP-сторінку за допомогою методу PRG
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Сталася внутрішня помилка сервера.");
        }
    }
}
