package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the delete.jsp page
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the customer order ID from the request parameter
        int customerOrderId = Integer.parseInt(request.getParameter("customerOrderId"));

        // Create an object of the InvoiceDao and call the deleteInvoice method
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        invoiceDao.deleteInvoice(customerOrderId);

        // Set a success message as a request attribute
        request.setAttribute("message", "Invoice Deleted successfully!");
        
        // Forward the request to the delete.jsp page
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }
}
