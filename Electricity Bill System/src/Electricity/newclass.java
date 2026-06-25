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
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.MouseAdapter;

public class newclass extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"id","name","mobile","address","sal"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    newclass(){
        super("Customer Details");
        setLocation(700,210);
        setSize(700,500);
        setUndecorated(true);
        try{
            Conn c1  = new Conn();
            String s1 = "select * from DELIEVERYMAN";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("D_ID");
                y[i][j++]=rs.getString("D_NAME");
                y[i][j++]=rs.getString("D_MOBILE");
                y[i][j++]=rs.getString("D_ADDRESS");
                y[i][j++]=rs.getString("D_SAL");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new newclass().setVisible(true);
    }   
}
