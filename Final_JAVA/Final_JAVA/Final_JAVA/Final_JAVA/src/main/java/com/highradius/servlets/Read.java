package com.highradius.servlets;
import com.highradius.model.Invoice;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Read extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create an object of the InvoiceDao and call the getInvoice method to retrieve all data
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        List<Invoice> invoices = invoiceDao.getInvoice();

        out.println("<html><body>");
        out.println("<h2>Invoice Data:</h2>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>CUSTOMER_ORDER_ID</th>");
        out.println("<th>SALES_ORG</th>");
        out.println("<th>DISTRIBUTION_CHANNEL</th>");
        out.println("<th>DIVISION</th>");
        out.println("<th>RELEASED_CREDIT_VALUE</th>");
        out.println("<th>PURCHASE_ORDER_TYPE</th>");
        out.println("<th>COMPANY_CODE</th>");
        out.println("<th>ORDER_CREATION_DATE</th>");
        out.println("<th>ORDER_CREATION_TIME</th>");
        out.println("<th>CREDIT_CONTROL_AREA</th>");
        out.println("<th>SOLD_TO_PARTY</th>");
        out.println("<th>ORDER_AMOUNT</th>");
        out.println("<th>REQUESTED_DELIVERY_DATE</th>");
        out.println("<th>ORDER_CURRENCY</th>");
        out.println("<th>CREDIT_STATUS</th>");
        out.println("<th>CUSTOMER_NUMBER</th>");
        out.println("<th>AMOUNT_IN_USD</th>");
        out.println("<th>UNIQUE_CUST_ID</th>");
        out.println("</tr>");

        // Loop through the list of invoices and display the data in the table
        for (Invoice invoice : invoices) {
            out.println("<tr>");
            out.println("<td>" + invoice.getCustomerOrderId() + "</td>");
            out.println("<td>" + invoice.getSalesOrg() + "</td>");
            out.println("<td>" + invoice.getDistributionChannel() + "</td>");

            out.println("<td>" + invoice.getCompanyCode() + "</td>");
            out.println("<td>" + invoice.getOrderCreationDate() + "</td>");

            out.println("<td>" + invoice.getOrderAmount() + "</td>");

            out.println("<td>" + invoice.getOrderCurrency() + "</td>");

            out.println("<td>" + invoice.getCustomerNumber() + "</td>");
            out.println("<td>" + invoice.getAmountInUSD() + "</td>");

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
