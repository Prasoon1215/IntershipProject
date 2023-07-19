package com.highradius.implementation;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//It is a class file that implements the methods of InvoiceDao interface
public class InvoiceDaoImpl implements InvoiceDao {
    @Override
    public List<Invoice> getInvoice() {
        List<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT * FROM h2h_oap LIMIT 200";	

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int customerOrderId = resultSet.getInt("CUSTOMER_ORDER_ID");
                int salesOrg = resultSet.getInt("SALES_ORG");
                String distributionChannel = resultSet.getString("DISTRIBUTION_CHANNEL");
                int companyCode = resultSet.getInt("COMPANY_CODE");
                String orderCreationDate = resultSet.getString("ORDER_CREATION_DATE");                
                String orderCurrency = resultSet.getString("ORDER_CURRENCY");               
                int customerNumber = resultSet.getInt("CUSTOMER_NUMBER");
                double amountInUSD = resultSet.getDouble("AMOUNT_IN_USD");
                double orderAmount = resultSet.getDouble("ORDER_AMOUNT");             

                Invoice invoice = new Invoice(customerOrderId,salesOrg, distributionChannel, 
                		companyCode,orderCreationDate, orderCurrency,customerNumber,
                		amountInUSD,orderAmount
                               );
                
                //storing into the array list of invoices
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        String sql = "INSERT INTO h2h_oap (CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL,  " +
                "COMPANY_CODE, ORDER_CREATION_DATE, " +
                "ORDER_AMOUNT,ORDER_CURRENCY, " +
                "CUSTOMER_NUMBER, AMOUNT_IN_USD) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set values for the prepared statement
            statement.setInt(1, invoice.getCustomerOrderId());
            statement.setInt(2, invoice.getSalesOrg());
            statement.setString(3, invoice.getDistributionChannel());
            statement.setInt(7, invoice.getCompanyCode());
            statement.setString(8, invoice.getOrderCreationDate());

            statement.setDouble(12, invoice.getOrderAmount());

            statement.setString(14, invoice.getOrderCurrency());

            statement.setInt(16, invoice.getCustomerNumber());
            statement.setDouble(17, invoice.getAmountInUSD());


            // Execute the SQL statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInvoice(int id, Invoice invoice) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE h2h_oap SET " +
                     "SALES_ORG=?, DISTRIBUTION_CHANNEL=? " +
                     "COMPANY_CODE=?, ORDER_CREATION_DATE=?, " +
                     "ORDER_AMOUNT=?, " +
                     " ORDER_CURRENCY=?,CUSTOMER_NUMBER=?, " +
                     "AMOUNT_IN_USD=? WHERE CUSTOMER_ORDER_ID=?")) {

            preparedStatement.setInt(2, invoice.getSalesOrg());
            preparedStatement.setString(3, invoice.getDistributionChannel());

            preparedStatement.setInt(7, invoice.getCompanyCode());
            preparedStatement.setString(8, invoice.getOrderCreationDate());

            preparedStatement.setDouble(12, invoice.getOrderAmount());

            preparedStatement.setString(14, invoice.getOrderCurrency());

            preparedStatement.setInt(16, invoice.getCustomerNumber());
            preparedStatement.setDouble(17, invoice.getAmountInUSD());

            preparedStatement.setInt(19, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteInvoice(int id) {

    	  try {
              // Establish the database connection and create a statement
              Connection connection = DatabaseConnection.getConnection();
              PreparedStatement statement = connection.prepareStatement("DELETE FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?");

              // Set the parameter value
              statement.setInt(1, id);

              // Execute the query
              statement.executeUpdate();

              // Close the statement and connection
              statement.close();
              connection.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
    	
    }
