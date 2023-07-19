package com.highradius.servlets;

import com.highradius.model.Invoice;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the add.jsp page
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the invoice data from the request parameters
        int customerOrderId = Integer.parseInt(request.getParameter("customerOrderId"));
        int salesOrg = Integer.parseInt(request.getParameter("salesOrg"));
        String distributionChannel = request.getParameter("distributionChannel");
        int companyCode = Integer.parseInt(request.getParameter("companyCode"));
        String orderCreationDate = request.getParameter("orderCreationDate");

        double orderAmount = Double.parseDouble(request.getParameter("orderAmount"));

        String orderCurrency = request.getParameter("orderCurrency");
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        double amountInUSD = Double.parseDouble(request.getParameter("amountInUSD"));

        // Create an object of the Invoice class with the retrieved data
        Invoice invoice = new Invoice(customerOrderId,salesOrg, distributionChannel, 
        		companyCode,orderCreationDate, orderCurrency,customerNumber,
        		amountInUSD,orderAmount	
                       );

        // Create an object of the InvoiceDao and call the insertInvoice method
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        invoiceDao.insertInvoice(invoice);

        // Set a success message as a request attribute
        request.setAttribute("message", "Invoice added successfully!");

        // Forward the request to the add.jsp page
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}

