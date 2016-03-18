/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author hpanjwani
 */
public class randomval {
    
float max =200;
float min = 100;
        Random rand = new Random();
    public static float currRand;
    
    
    public randomval() {
        currRand = rand.nextInt(99);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currRand = rand.nextInt(99);
            }
        };
        Timer timer = new Timer(2000, actionListener);
        timer.start();
    }
    public static void main(String args[]) throws InterruptedException {
      
        randomval te = new randomval();
        while( true ) {
            Thread.currentThread().sleep(3000);
            System.out.println("current value:" + currRand );
        }
    }
}
