package com.example.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class ProductSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ініціалізація сервісу пошуку продуктів
        ProductSearchService service = new ProductSearchService();

        // Створення продуктів
        Product laptop = new Product("Ноутбук", 1000.0); // Ноутбук з рекомендованою ціною 1000
        Product smartphone = new Product("Смартфон", 500.0); // Смартфон з рекомендованою ціною 500
        Product tablet = new Product("Планшет", 750.0); // Планшет з рекомендованою ціною 750

        // Створення магазинів і додавання продуктів
        OnlineStore techStore = new OnlineStore("Розетка"); // Магазин техніки
        techStore.addProduct(laptop, 950.0); // Додавання ноутбука зі знижкою
        techStore.addProduct(smartphone, 450.0); // Додавання смартфона зі знижкою

        OnlineStore gadgetStore = new OnlineStore("Комфі"); // Магазин гаджетів
        gadgetStore.addProduct(tablet, 700.0); // Додавання планшета зі знижкою
        gadgetStore.addProduct(smartphone, 480.0); // Той же смартфон, але в іншому магазині та з іншою ціною

        // Додавання магазинів до сервісу
        service.addStore(techStore);
        service.addStore(gadgetStore);

        // Отримання назви продукту з запиту
        String productName = request.getParameter("productName");
        // Пошук мінімальної ціни на продукт
        double minPrice = service.findMinimumPrice(productName);
        // Отримання списку магазинів, де є продукт за мінімальною ціною
        List<String> stores = service.storesWithMinimumPrice(productName);

        // Встановлення атрибутів для JSP
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("stores", stores);

        // Перенаправлення запиту на JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
