package com.example.laba2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", value = "/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()){
            out.println("<html>");
            out.println("<head> <title>Servlet Calculator</title> </head>");
            out.println("<body>");
            out.println("<h1>Cookies:</h1>");
            for (Cookie c : req.getCookies()) {
                out.println(c.getName() + " " + c.getValue() + "<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
