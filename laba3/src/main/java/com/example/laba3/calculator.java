package com.example.laba3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", value = "/calculator")
public class calculator extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Отримання значень з параметрів запиту
        String firstValue = request.getParameter("first");
        String secondValue = request.getParameter("second");
        String thirdValue = request.getParameter("third");
        String fourthValue = request.getParameter("fourth");

        // Створення кукі для кожного параметра
        Cookie firstCookie = new Cookie("first", firstValue);
        Cookie secondCookie = new Cookie("second", secondValue);
        Cookie thirdCookie = new Cookie("third", thirdValue);
        Cookie fourthCookie = new Cookie("fourth", fourthValue);

        // Додавання кожної кукі до відповіді
        response.addCookie(firstCookie);
        response.addCookie(secondCookie);
        response.addCookie(thirdCookie);
        response.addCookie(fourthCookie);

        // Перенаправте на іншу сторінку або виведіть відповідь
        // наприклад, можна перенаправити на сторінку, яка відображає збережені значення кукі
        response.sendRedirect("index.jsp");
    }
}
