package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "delete":
                deleteProduct(req,resp);
                break;
            case "update":
                showUpdate(req,resp);
                break;
            case "create":
                showCreate(req,resp);
                break;
            default:
                showProduct(req,resp);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        showProduct(req,resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("categories", categoryService.findAll());
        req.setAttribute("product", product);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categoryService.findAll());
        req.getRequestDispatcher("create.jsp").forward(req,resp);
        showProduct(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "update":
                updateProduct(req,resp);
                break;
            default:
                showProduct(req,resp);
        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("search");
        req.setAttribute("productSearch",productService.searchProduct(name));
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(id,name,price,quantity,category);
        productService.update(product);
        showProduct(req,resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(name,price,quantity, category);
        productService.create(product);
//        req.setAttribute("category", category);
        req.setAttribute("message","Created");
        req.getRequestDispatcher("create.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        if(search == null){
            search = "";
        }
        req.setAttribute("categories",categoryService.findAll());
        req.setAttribute("products", productService.searchProduct(search));
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }



}
