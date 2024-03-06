package com.example.demo2;

import jakarta.servlet.RequestDispatcher;
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

// Отримання та перевірка параметрів
        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");
        String stepStr = request.getParameter("step");
        String exampleType = request.getParameter("exampleType");

        double start = startStr != null ? Double.parseDouble(startStr) : 0;
        double end = endStr != null ? Double.parseDouble(endStr) : 10;
        double step = stepStr != null ? Double.parseDouble(stepStr) : 1;

// Обчислення результатів
        List<Double[]> results = new ArrayList<>();
        for (double i = start; i <= end; i += step) {
            double result1 = 0.0, result2 = 0.0, result3 = 0.0;
            switch (exampleType) {
                case "1":
                    result1 = 3 * (Math.log(Math.abs(i / (i + 1)))) + Math.sqrt(Math.cos(i) + Math.exp(i + 1));
                    break;
                case "2":
                    result2 = 6 * Math.sin(Math.abs(2 * i)) * Math.log(i + 1) + Math.sqrt(i * Math.cosh(-1 * (i + 1)));
                    break;
                case "3":
                    result3 = Math.pow(2 * Math.sin(i) + Math.cos(Math.abs(i + 1)) * Math.sqrt(i), i + 1);
                    break;
            }
            results.add(new Double[]{i, result1, result2, result3});
        }

// Збереження результатів обчислень для доступу з JSP
        request.setAttribute("results", results);

// Встановлення значень кукі
        Cookie startCookie = new Cookie("start", startStr);
        Cookie endCookie = new Cookie("end", endStr);
        Cookie stepCookie = new Cookie("step", stepStr);
        Cookie exampleTypeCookie = new Cookie("exampleType", exampleType);

// Встановлення максимального часу життя кукі
        startCookie.setMaxAge(60*60*24); // 1 день
        endCookie.setMaxAge(60*60*24);
        stepCookie.setMaxAge(60*60*24);
        exampleTypeCookie.setMaxAge(60*60*24);

// Додавання кукі до відповіді
        response.addCookie(startCookie);
        response.addCookie(endCookie);
        response.addCookie(stepCookie);
        response.addCookie(exampleTypeCookie);
// Перенаправлення запиту назад на JSP сторінку
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }


}
