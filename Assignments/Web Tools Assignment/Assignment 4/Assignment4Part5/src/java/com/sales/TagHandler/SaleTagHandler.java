/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.TagHandler;

import com.sales.DAO.SalesReadDAO;
import com.sales.bean.SaleBean;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author hpanjwani
 */
public class SaleTagHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    private String fileName;
    private ArrayList<SaleBean> saleList = null;
    
    public void setFile(String fileName) {
        this.fileName = fileName;
    }
    
    public void setSaleList(ArrayList<SaleBean> saleList) {
        this.saleList = saleList;
    }
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
//            SalesReadDAO dao = new SalesReadDAO();        
//            ArrayList<SaleBean> saleList = (ArrayList<SaleBean>) dao.getAllSaleDetails(fileName);
            
            for(SaleBean sale : saleList) {

            out.println("<tr>\n" +
"                    <td><input type='text' name='saleOrderID' value='"+ sale.getSalesOrderID() +"' /></td>\n" +
"                    <td><input type='text' name='revisionNumber' value='"+ sale.getRevisionNumber()+"' /></td>\n" +
"                    <td><input type='text' name='orderDate' value='"+ sale.getOrderDate()+"' /></td>     \n" +
"                    <td><input type='text' name='dueDate' value='"+ sale.getDueDate()+"' /></td>\n" +
"                    <td><input type='text' name='shipDate' value='"+ sale.getShipDate()+"' /></td>\n" +
"                    <td><input type='text' name='status' value='"+ sale.getStatus()+"' /></td>\n" +
"                    <td><input type='text' name='onlineOrderFlag' value='"+ sale.getOnlineOrderFlag()+"' /></td>\n" +
"                    <td><input type='text' name='salesOrderNumber' value='"+ sale.getSalesOrderNumber()+"' /></td>\n" +
"                    <td><input type='text' name='purchaseOrderNumber' value='"+ sale.getPurchaseOrderNumber()+"' /></td>\n" +
"                    <td><input type='text' name='accountNumber' value='"+ sale.getAccountNumber()+"' /></td>\n" +
"                    <td><input type='text' name='customerID' value='"+ sale.getCustomerID()+"' /></td>\n" +
"                    <td><input type='text' name='salesPersonID' value='"+ sale.getSalesPersonID()+"' /></td>\n" +
"                    <td><input type='text' name='territoryID' value='"+ sale.getTerritoryID()+"' /></td>\n" +
"                    <td><input type='text' name='billToAddressID' value='"+ sale.getBillToAddressID()+"' /></td>\n" +
"                    <td><input type='text' name='shipToAddressID' value='"+ sale.getShipToAddressID()+"' /></td>\n" +
"                    <td><input type='text' name='shipMethodID' value='"+ sale.getShipMethodID()+"' /></td>\n" +
"                    <td><input type='text' name='creditCardID' value='"+ sale.getCreditCardID()+"' /></td>\n" +
"                    <td><input type='text' name='creditCardApprovalCode' value='"+ sale.getCreditCardApprovalCode()+"' /></td>\n" +
"                    <td><input type='text' name='currencyRateID' value='"+ sale.getCurrencyRateID()+"' /></td>\n" +
"                    <td><input type='text' name='subTotal' value='"+ sale.getSubTotal()+"' /></td>\n" +
"                    <td><input type='text' name='taxAmt' value='"+ sale.getTaxAmt()+"' /></td>\n" +
"                    <td><input type='text' name='freight' value='"+ sale.getFreight()+"' /></td>\n" +
"                    <td><input type='text' name='totalDue' value='"+ sale.getTotalDue()+"' /></td>\n" +
"                    <td><input type='text' name='comment' value='"+ sale.getComment()+"' /></td>\n" +
"                    <td><input type='text' name='modifiedDate' value='"+ sale.getModifiedDate()+"' /></td>\n" +
"                </tr>   \n");
            }            
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in SaleTagHandler tag", ex);
        }
    }
    
}
