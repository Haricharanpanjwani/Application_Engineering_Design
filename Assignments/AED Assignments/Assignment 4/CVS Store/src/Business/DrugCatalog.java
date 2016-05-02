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
public class DrugCatalog {
    
    private ArrayList<Drug> drugList;
    
    public DrugCatalog()    {
        drugList = new ArrayList<Drug>();
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }
    
    public Drug addDrug(){
        Drug drug = new Drug();
        drugList.add(drug);
        return drug;
    }
    
    public void removeDrug(Drug drug){
        drugList.remove(drug);
    }
    
    public Drug searchDrug(String name){
        for (Drug drug : drugList) {
            if(drug.getDrugName().equals(name)){
                return drug;
            }
        }
        return null;
    }
    
}
