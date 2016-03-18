/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author hpanjwani
 */
public class Validation {
    
    public boolean checkForAlphabets(java.awt.event.FocusEvent evt, JTextField nameTextField, JLabel nameLabel) {
        final JTextComponent c = (JTextComponent) evt.getSource();
        String s = c.getText();

        if (evt.isTemporary()) {
          return true;
        }
        if (!(s.matches("[a-zA-Z]*"))) {
            nameLabel.setText(nameTextField + " will only have alphabets");
            nameTextField.setBackground(Color.yellow);
            return false;
        }
        else if(s.trim().isEmpty()) {
            nameLabel.setText(nameTextField + " cannot be blank");
            nameTextField.setBackground(Color.yellow);
            return false;
        }
        else{
            nameLabel.setText("");
            nameTextField.setBackground(Color.white);
            return true;
        }
    }
    
    public boolean checkForAlphabetsAndDigits(JTextField usernameTextField, JLabel userNameLabel) {
        if (!(usernameTextField.getText().matches("[a-zA-Z0-9]+"))) {
            //userNameLabel.setText(usernameTextField + " will only have alphabets and digits");
            usernameTextField.setBackground(Color.yellow);
            return false;
        } else if (usernameTextField.getText().trim().isEmpty()) {
            //userNameLabel.setText(userNameLabel + " cannot be blank");
            usernameTextField.setBackground(Color.yellow);
            return false;
        } else {
            userNameLabel.setText("");
            usernameTextField.setBackground(Color.white);
            return true;
        }
    }
    
    public boolean notEmpty(JTextField usernameTextField, JLabel userNameLabel) {
        if (usernameTextField.getText().trim().isEmpty()) {
            //userNameLabel.setText(userNameLabel + " cannot be blank");
            usernameTextField.setBackground(Color.yellow);
            return false;
        } else {
            userNameLabel.setText("");
            usernameTextField.setBackground(Color.white);
            return true;
        }
    }
}
