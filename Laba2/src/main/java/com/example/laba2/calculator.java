package com.example.laba2;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String firstParam = req.getParameter("firstParam");
        String secondParam = req.getParameter("secondParam");
        String thirdParam = req.getParameter("thirdParam");
        String fourthParam = req.getParameter("fourthParam");
        double first, second, third, fourth;

        String formNumber = req.getParameter("formNumber");

        try {
             first = Double.parseDouble(firstParam);
             second = Double.parseDouble(secondParam);
             third = Double.parseDouble(thirdParam);
             fourth = Double.parseDouble(fourthParam);
        }catch (NumberFormatException e){
           resp.sendError(400, e.getMessage());
           return;
        }
        double result = 0.0;
        if ("1".equals(formNumber)) {
            result = 3 * (Math.log(Math.abs(first / second))) +
                    Math.sqrt(Math.cos(second) + Math.exp(fourth));
        } else if ("2".equals(formNumber)) {
            result = 6 * Math.sin(Math.abs(2 * first)) *
                    Math.log(second) +
                    Math.sqrt(third * Math.cosh(-1 * fourth));
        } else if ("3".equals(formNumber)) {
            result = Math.pow(2 * Math.sin(first) + Math.cos(Math.abs(second)) *
                    Math.sqrt(third), fourth);
        }

        Cookie firstParamCookie = new Cookie("firstParam", firstParam);
        Cookie secondParamCookie = new Cookie("secondParam", secondParam);
        Cookie thirdParamCookie = new Cookie("thirdParam", thirdParam);
        Cookie fourthParamCookie = new Cookie("fourthParam", fourthParam);

        firstParamCookie.setMaxAge(3600);
        secondParamCookie.setMaxAge(3600);
        thirdParamCookie.setMaxAge(3600);
        fourthParamCookie.setMaxAge(3600);

        resp.addCookie(firstParamCookie);
        resp.addCookie(secondParamCookie);
        resp.addCookie(thirdParamCookie);
        resp.addCookie(fourthParamCookie);

        Cookie[] cookies = req.getCookies();
        String firstParamSaver = getCookieValue(cookies, "firstParam");
        req.getSession().setAttribute("firstParamSaver", firstParamSaver);

        String secondParamSaver = getCookieValue(cookies, "secondParam");
        req.getSession().setAttribute("secondParamSaver", secondParamSaver);

        String thirdParamSaver = getCookieValue(cookies, "thirdParam");
        req.getSession().setAttribute("thirdParamSaver", thirdParamSaver);

        String fourthParamSaver = getCookieValue(cookies, "fourthParam");
        req.getSession().setAttribute("fourthParamSaver", fourthParamSaver);

        try(PrintWriter out = resp.getWriter()){
            out.println("<html>");
            out.println("<head> <title>Servlet Calculator</title> </head>");
            out.println("<body>");
            out.println("<h1>" + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    private String getCookieValue(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}