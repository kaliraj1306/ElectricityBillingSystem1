/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

/**
 *
 * @author karth
 */

import java.awt.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author myash
 */
public class Captcha 
{
    public String Captcha1()
    {
        String captcha = null;
        char data[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
        char index[] = new char[7];
        Random r = new Random();
        int i =0 ;
        for( i = 0;i<(index.length);i++)
        {
            int rar = r.nextInt(data.length);
            index[i] = data[rar];
            captcha = String.valueOf(index);
           
    
        }
         return captcha;
    }
    public static void main(String args[])
    {
        Captcha l = new Captcha();
        l.Captcha1();
    }
}
