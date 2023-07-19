<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Invoice</title>
</head>
<body>
    <h1>Add Invoice</h1>

    <%-- Display success message if available --%>
    <c:if test=${not empty message}">
        <div style="color: green;">${message}</div>
    </c:if>

    <form action="add" method="post">
        <label for="customerOrderId">Customer Order ID:</label>
        <input type="text" id="customerOrderId" name="customerOrderId"><br>

        <label for="salesOrg">Sales Org:</label>
        <input type="text" id="salesOrg" name="salesOrg"><br>

        <label for="distributionChannel">Distribution Channel:</label>
        <input type="text" id="distributionChannel" name="distributionChannel"><br>

        <label for="division">Division:</label>
        <input type="text" id="division" name="division"><br>

        <label for="releasedCreditValue">Released Credit Value:</label>
        <input type="text" id="releasedCreditValue" name="releasedCreditValue"><br>

        <label for="purchaseOrderType">Purchase Order Type:</label>
        <input type="text" id="purchaseOrderType" name="purchaseOrderType"><br>

        <label for="companyCode">Company Code:</label>
        <input type="text" id="companyCode" name="companyCode"><br>

        <label for="orderCreationDate">Order Creation Date:</label>
        <input type="text" id="orderCreationDate" name="orderCreationDate"><br>

        <label for="orderCreationTime">Order Creation Time:</label>
        <input type="text" id="orderCreationTime" name="orderCreationTime"><br>

        <label for="creditControlArea">Credit Control Area:</label>
        <input type="text" id="creditControlArea" name="creditControlArea"><br>

        <label for="soldToParty">Sold To Party:</label>
        <input type="text" id="soldToParty" name="soldToParty"><br>

        <label for="orderAmount">Order Amount:</label>
        <input type="text" id="orderAmount" name="orderAmount"><br>

        <label for="requestedDeliveryDate">Requested Delivery Date:</label>
        <input type="text" id="requestedDeliveryDate" name="requestedDeliveryDate"><br>

        <label for="orderCurrency">Order Currency:</label>
        <input type="text" id="orderCurrency" name="orderCurrency"><br>

        <label for="creditStatus">Credit Status:</label>
        <input type="text" id="creditStatus" name="creditStatus"><br>

        <label for="customerNumber">Customer Number:</label>
        <input type="text" id="customerNumber" name="customerNumber"><br>

        <label for="amountInUSD">Amount in USD:</label>
        <input type="text" id="amountInUSD" name="amountInUSD"><br>

        <label for="uniqueCustId">Unique Cust ID:</label>
        <input type="text" id="uniqueCustId" name="uniqueCustId"><br>

        <input type="submit" value="Add Invoice">
    </form>
</body>
</html>
