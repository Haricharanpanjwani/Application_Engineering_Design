/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.Toolkit;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author hpanjwani
 */
public class DemoT {

    Toolkit toolkit;
    Timer timer;

    public DemoT() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 10, //initial delay
                3 * 1000); //subsequent rate
    }

    class RemindTask extends TimerTask {

        int numWarningBeeps = 3;

        public void run() {
            if (numWarningBeeps > 0) {
                toolkit.beep();
                System.out.println("Beep!");
                numWarningBeeps--;
            } else {
                toolkit.beep();
                System.out.println("Time's up!");
                //timer.cancel(); //Not necessary because we call System.exit
                System.exit(0); //Stops the AWT thread (and everything else)
            }
        }
    }
    
    public static void main(String args[]) {
        

        System.out.println("About to schedule task.");        
            new DemoT();
        System.out.println("Task scheduled.");

    }
}
