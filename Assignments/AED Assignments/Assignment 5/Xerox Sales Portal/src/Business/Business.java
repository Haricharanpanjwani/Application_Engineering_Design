/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author hpanjwani
 */
public class Business {
    
    private OrderCatalog orderCatalog;
    private SupplierDirectory supplierDirectory;
    private CustomerDirectory customerDirectory;
    private SalePersonDirectory salePersonDirectory;
    
    public Business()   {
        orderCatalog = new OrderCatalog();
        supplierDirectory = new SupplierDirectory();
        customerDirectory = new CustomerDirectory();
        salePersonDirectory = new SalePersonDirectory();
        
        initializeCustomer();
    }
    
    public void initializeCustomer()    {
        
        Customer cust = customerDirectory.addCustomer("Hari");
        Customer cust1 = customerDirectory.addCustomer("Shivam");
        Customer cust2 = customerDirectory.addCustomer("Tarun");
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public SalePersonDirectory getSalePersonDirectory() {
        return salePersonDirectory;
    }

    public void setSalePersonDirectory(SalePersonDirectory salePersonDirectory) {
        this.salePersonDirectory = salePersonDirectory;
    }
    
}
