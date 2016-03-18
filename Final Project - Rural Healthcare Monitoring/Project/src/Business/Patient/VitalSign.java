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
public class VitalSign {
    
    private float respRate;
    private float heartRate;
    private float bp;
    private float weight;
    private float temp;
    private float platelets;
    private int pulse;
    private String bloodGroup;
    private float hemo;
    private float glucose;
    
    private String time;
    
    private AirQuality airQuality;
    
    //Timestamp timeStamp = new Timestamp(new Date().getTime());
    //time = String.valueOf(timeStamp);
    Date date =  new Date();
    
    public VitalSign()  {
        airQuality = new AirQuality();
    }

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }
    
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

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPlatelets() {
        return platelets;
    }

    public void setPlatelets(float platelets) {
        this.platelets = platelets;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public float getHemo() {
        return hemo;
    }

    public void setHemo(float hemo) {
        this.hemo = hemo;
    }

    public float getGlucose() {
        return glucose;
    }

    public void setGlucose(float glucose) {
        this.glucose = glucose;
    }
    
    @Override
    public String toString()   {
        return String.valueOf(this.time);
    }
}
