package com.example.demomcvc11.controller;

import com.example.demomcvc11.model.Customer;
import com.example.demomcvc11.service.CustomerService;
import com.example.demomcvc11.service.CustomerServiceImpl;
import com.example.demomcvc11.service.CustomerServiceMySql;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceMySql();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        //lay du lieu tu sevice
        List<Customer> customers = customerService.findAll();
        //chuyen du lieu sang view
        request.setAttribute("ds", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creatNewCustomer(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void creatNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        //lay cac tham so
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int id = (int)(Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);

        customerService.save(customer);
        System.out.println(customerService.findAll());
    }
}
