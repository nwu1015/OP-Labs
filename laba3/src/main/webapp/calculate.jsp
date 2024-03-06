<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.Math" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Результати обчислень</title>
</head>
<body>

<%!
    double calculate(double first, double second, double third, double fourth) {
        return 3 * (Math.log(Math.abs(first / second))) + Math.sqrt(Math.cos(third) + Math.exp(fourth));
    }
%>

<%
    PrintWriter abc = response.getWriter();
    String firstStr = request.getParameter("first");
    String firstToStr = request.getParameter("firstTo");
    String firstStepStr = request.getParameter("firstStep");

    String secondStr = request.getParameter("second");
    String secondToStr = request.getParameter("secondTo");
    String secondStepStr = request.getParameter("secondStep");

    String thirdStr = request.getParameter("third");
    String thirdToStr = request.getParameter("thirdTo");
    String thirdStepStr = request.getParameter("thirdStep");

    String fourthStr = request.getParameter("fourth");
    String fourthToStr = request.getParameter("fourthTo");
    String fourthStepStr = request.getParameter("fourthStep");

    if (firstStr != null && secondStr != null && thirdStr != null && fourthStr != null) {
        double first = Double.parseDouble(firstStr);
        double firstTo = Double.parseDouble(firstToStr);
        double firstStep = Double.parseDouble(firstStepStr);

        double second = Double.parseDouble(secondStr);
        double secondTo = Double.parseDouble(secondToStr);
        double secondStep = Double.parseDouble(secondStepStr);

        double third = Double.parseDouble(thirdStr);
        double thirdTo = Double.parseDouble(thirdToStr);
        double thirdStep = Double.parseDouble(thirdStepStr);

        double fourth = Double.parseDouble(fourthStr);
        double fourthTo = Double.parseDouble(fourthToStr);
        double fourthStep = Double.parseDouble(fourthStepStr);

        abc.print("<table border=\"1\">");
        abc.print("<tr>");
        abc.print("<th>Перше значення</th>");
        abc.print("<th>Друге значення</th>");
        abc.print("<th>Третє значення</th>");
        abc.print("<th>Четверте значення</th>");
        abc.print("<th>Результат</th>");
        abc.print("</tr>");

        for (double i = first; i <= firstTo; i += firstStep) {
            for (double j = second; j <= secondTo; j += secondStep) {
                for (double g = third; g <= thirdTo; g += thirdStep) {
                    for (double h = fourth; h < fourthTo; h += fourthStep) {
                        abc.print("<tr>");
                        abc.print("<td>" + i + "</td>");
                        abc.print("<td>" + j + "</td>");
                        abc.print("<td>" + g + "</td>");
                        abc.print("<td>" + h + "</td>");
                        double result = calculate(i, j, g, h);
                        abc.print("<td>" + result + "</td>");
                        abc.print("</tr>");
                    }
                }
            }
        }
        abc.print("</table>");
    }
%>
</body>
</html>
