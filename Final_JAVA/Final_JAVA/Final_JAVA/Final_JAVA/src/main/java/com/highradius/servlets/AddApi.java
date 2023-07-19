package com.highradius.servlets;

import com.highradius.model.Invoice;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import org.json.JSONObject;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/api/addInvoice")
public class AddApi extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the invoice data from the request parameters
        int customerOrderId = Integer.parseInt(request.getParameter("customerOrderId"));
        int salesOrg = Integer.parseInt(request.getParameter("salesOrg"));
        String distributionChannel = request.getParameter("distributionChannel");
//        String division = request.getParameter("division");
//        double releasedCreditValue = Double.parseDouble(request.getParameter("releasedCreditValue"));
//        String purchaseOrderType = request.getParameter("purchaseOrderType");
        int companyCode = Integer.parseInt(request.getParameter("companyCode"));
        String orderCreationDate = request.getParameter("orderCreationDate");
//        String orderCreationTime = request.getParameter("orderCreationTime");
//        String creditControlArea = request.getParameter("creditControlArea");
//        int soldToParty = Integer.parseInt(request.getParameter("soldToParty"));
        double orderAmount = Double.parseDouble(request.getParameter("orderAmount"));
//        String requestedDeliveryDate = request.getParameter("requestedDeliveryDate");
        String orderCurrency = request.getParameter("orderCurrency");
//        String creditStatus = request.getParameter("creditStatus");
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        double amountInUSD = Double.parseDouble(request.getParameter("amountInUSD"));
//        String uniqueCustId = request.getParameter("uniqueCustId");

        // Create an instance of the Invoice class with the retrieved data
        Invoice invoice =  new Invoice(customerOrderId,salesOrg, distributionChannel, 
        		companyCode,orderCreationDate, orderCurrency,customerNumber,
        		amountInUSD,orderAmount	
                       );

        // Create an instance of the InvoiceDao and call the insertInvoice method
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        invoiceDao.insertInvoice(invoice);

        // Create a JSON response with success message
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "success");
        jsonResponse.put("message", "Invoice data added successfully");

        // Set the response content type to application/json
        response.setContentType("application/json");

        // Write the JSON response to the response writer
        response.getWriter().write(jsonResponse.toString());
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Disallow the GET method for this URL
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
