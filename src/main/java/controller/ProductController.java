package controller;

import model.Product;
import service.IService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private IService<Product> productIService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request, response);
                break;
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showFormError(request, response);
        }

    }

    public void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productIService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/home.jsp");
        request.setAttribute("productList", productList);
        dispatcher.forward(request, response);
    }

    public void showFormError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error/notFound.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productIService.findProductById(id);
        request.setAttribute("editProduct", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productIService.delete(id);
        response.sendRedirect("/products?action=home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                addProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
        }
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id, name, quantity, price, image);
        productIService.add(product);
        response.sendRedirect("/products?action=home");
    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id, name, quantity, price, image);
        productIService.edit(product, id);
        response.sendRedirect("/products?action=home");
    }
}