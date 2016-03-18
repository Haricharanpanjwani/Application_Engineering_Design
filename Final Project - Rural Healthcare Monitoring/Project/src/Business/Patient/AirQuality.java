/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class AirQuality {
    
    private String pm;
    private String pmTen;
    private String time;
    
    Date date = new Date();

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getPmTen() {
        return pmTen;
    }

    public void setPmTen(String pmTen) {
        this.pmTen = pmTen;
    }
    
    public Date getTime() {
        return new Timestamp(date.getTime());
    }

    public void setTime(String time) {
        this.time = time;
    }
}
