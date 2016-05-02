/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class SalePersonDirectory {
    
    private ArrayList<SalePerson> salePersonDirectory;
    
    public SalePersonDirectory()   {
        salePersonDirectory = new ArrayList<SalePerson>();
    }

    public ArrayList<SalePerson> getSalePersonDirectory() {
        return salePersonDirectory;
    }

    public void setSalePersonDirectory(ArrayList<SalePerson> salePersonDirectory) {
        this.salePersonDirectory = salePersonDirectory;
    }
    
    public SalePerson addSalePerson() {
        
        SalePerson s = new SalePerson();
        salePersonDirectory.add(s);
        return s;
    }
    
    public void removeSalePerson(SalePerson s)  {
        salePersonDirectory.remove(s);
    }
    
}
