package Electricity;

import java.sql.*;  
import java.awt.*;
import javax.swing.*;

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/elect","root","");
            s =c.createStatement();
            //JOptionPane.showMessageDialog(null,"Connected");
            
        }catch(Exception e){ 
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "not connected");
        } 
    }
        public static void main(String args[])
        {
            new Conn();
        }
}  