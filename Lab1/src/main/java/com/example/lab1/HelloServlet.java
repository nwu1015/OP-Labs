package com.example.lab1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Сервлет приклад</title></head>");
        out.println("<body>");
        out.println("<h1>Привіт, це сервлет!</h1>");
        out.println("<p>Це сервлет.</p>");
        out.println("</body></html>");
    }


}