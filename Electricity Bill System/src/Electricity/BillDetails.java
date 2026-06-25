package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame implements ActionListener{
 
    JTable t1;
    String x[] = {"Month","Units","Total Bill","Status"};
    String y[][] = new String[40][4];
    JButton b1;
    
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        
       setLocation(700,210);
        setSize(700,500);
        setUndecorated(true);
       
        
        t1 = new JTable(y,x);
        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill where meter = '"+meter+"';";
            ResultSet rs  = c.s.executeQuery(s1);
            
            while(rs.next()){
                y[i][j++]=rs.getString("month");
                y[i][j++]=rs.getString("units");
                y[i][j++]=rs.getString("total_bill");
                y[i][j++]=rs.getString("status");
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
        new BillDetails("").setVisible(true);
    }
    
}
