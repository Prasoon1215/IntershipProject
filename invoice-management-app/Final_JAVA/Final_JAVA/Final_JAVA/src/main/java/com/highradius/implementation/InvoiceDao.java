package com.highradius.implementation;

import com.highradius.model.Invoice;

import java.util.List;

//It is an interface for the following methods
public interface InvoiceDao {
	
	//it will receive a list of all invoices
    List<Invoice> getInvoice();
    //insert data into the database
    void insertInvoice(Invoice invoice);
    //update data into the database
    void updateInvoice(int id, Invoice invoice);
    //delete data from the database
    void deleteInvoice(int id);
}
