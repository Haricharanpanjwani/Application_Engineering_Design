package Business.Sensor;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpanjwani
 */
public class Sensor {
    
    public int generateBp() {
       Random r = new Random();
       int Low = 60;
       int High = 110;
       int Result = r.nextInt(High - Low) + Low;
       return Result;
   }
    
}
