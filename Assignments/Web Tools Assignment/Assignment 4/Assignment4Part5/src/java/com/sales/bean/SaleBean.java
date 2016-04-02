/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.bean;

/**
 *
 * @author hpanjwani
 */
public class SaleBean {
    
    int salesOrderID;
    int revisionNumber;
    String orderDate;
    String dueDate;
    String shipDate;
    int status;
    String onlineOrderFlag;
    String salesOrderNumber;
    String purchaseOrderNumber;
    String accountNumber;
    int customerID;	
    int salesPersonID;
    int territoryID;
    int billToAddressID;
    int shipToAddressID;
    int shipMethodID;
    int creditCardID;
    String creditCardApprovalCode;
    String currencyRateID;
    float subTotal;
    float taxAmt;
    float freight;
    String totalDue;
    String comment;
    String modifiedDate;

    public int getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOnlineOrderFlag() {
        return onlineOrderFlag;
    }

    public void setOnlineOrderFlag(String onlineOrderFlag) {
        this.onlineOrderFlag = onlineOrderFlag;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(int salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public int getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public int getBillToAddressID() {
        return billToAddressID;
    }

    public void setBillToAddressID(int billToAddressID) {
        this.billToAddressID = billToAddressID;
    }

    public int getShipToAddressID() {
        return shipToAddressID;
    }

    public void setShipToAddressID(int shipToAddressID) {
        this.shipToAddressID = shipToAddressID;
    }

    public int getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(int shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public int getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(int creditCardID) {
        this.creditCardID = creditCardID;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    public String getCurrencyRateID() {
        return currencyRateID;
    }

    public void setCurrencyRateID(String currencyRateID) {
        this.currencyRateID = currencyRateID;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(float taxAmt) {
        this.taxAmt = taxAmt;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public String getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(String totalDue) {
        this.totalDue = totalDue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
