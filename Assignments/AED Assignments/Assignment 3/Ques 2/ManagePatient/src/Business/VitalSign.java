/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class VitalSign {
    
    private float respRate;
    private float heartRate;
    private float bp;
    private float weight;
    private String time;
    
    Date date = new Date();

    public float getRespRate() {
        return respRate;
    }

    public void setRespRate(float respRate) {
        this.respRate = respRate;
    }

    public float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }

    public float getBp() {
        return bp;
    }

    public void setBp(float bp) {
        this.bp = bp;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public Date getTime() {
        return new Timestamp(date.getTime());
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String toString()    {
        return String.valueOf(getTime());
    }
    
}
