package com.highradius.model;

//This is the structure for storing the data into various columns
//It also has getters and setters for every column/variable

public class Invoice {
	private int customerOrderId;
    private int salesOrg;
    private String distributionChannel;
    private int companyCode;
    private String orderCreationDate;
    private double orderAmount;
    private String orderCurrency;
    private int customerNumber;
    private double amountInUSD;


    // Parameterized Constructor
    public Invoice(int customerOrderId, int salesOrg, String distributionChannel, 
    		int companyCode,String orderCreationDate,String orderCurrency,int customerNumber,
    		double amountInUSD,double orderAmount
                   ) {
        this.customerOrderId = customerOrderId;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.companyCode = companyCode;
        this.orderCreationDate = orderCreationDate;
        this.orderCurrency = orderCurrency;
        this.customerNumber = customerNumber;
        this.amountInUSD = amountInUSD;
        this.orderAmount = orderAmount;
    }

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public int getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(int salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

		public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	

	
	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public double getAmountInUSD() {
		return amountInUSD;
	}

	public void setAmountInUSD(double amountInUSD) {
		this.amountInUSD = amountInUSD;
	}

	public double getOrderAmount() {
		return orderAmount;
	}
	
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}


 
}
