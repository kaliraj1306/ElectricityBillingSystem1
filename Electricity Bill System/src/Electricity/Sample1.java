/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.text.html.HTML.Tag.P;


public class Sample1 extends JFrame implements ActionListener{
    String meter;
    JLabel E;
    Sample1(String meter,String person){
        setTitle("ADMIN");
        setSize(1550,870);
        
        
        
        JButton l1 = new JButton("New Customer");
        l1.setForeground(Color.BLACK);  
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("monospaced",Font.BOLD,16));
        l1.setBounds(200, 270, 250, 30);
        add(l1);
               
        JButton l2 = new JButton("Customer Details");
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("monospaced",Font.BOLD,16));
        l2.setBounds(200, 330, 250, 30);
        add(l2);
        
        
        
        
        JButton l3 = new JButton("Deposit Details");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("monospaced",Font.BOLD,16));
        l3.setBounds(200, 390, 250, 30);
        add(l3);
        l3.setBackground(Color.WHITE);
        
            
        
        JButton l4 = new JButton("Calculate Bill");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("monospaced",Font.BOLD,16));       
        l4.setBounds(200, 450, 250, 30);
        add(l4);
        l4.setBackground(Color.WHITE);
        
        l1.addActionListener(this);
        l2.addActionListener(this);
        l3.addActionListener(this);
        l4.addActionListener(this);
        
        
        JButton l5 = new JButton("Calculator  ");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("monospaced",Font.BOLD,16));
        l5.setBounds(200, 510, 250, 30);
        add(l5);
        l5.setBackground(Color.WHITE);
        l5.addActionListener(this);
        
        JButton l6 = new JButton("Note pad  ");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("monospaced",Font.BOLD,16));       
        l6.setBounds(200, 570, 250, 30);
        add(l6);
        l6.setBackground(Color.WHITE);
        l6.addActionListener(this);
        
        
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        JButton l10 = new JButton("Logout",new ImageIcon(i4));
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("monospaced",Font.BOLD,10));       
        l10.setBounds(1420, 785, 100, 20);
        l10.addActionListener(this);
        add(l10);
              
         
        JLabel l8 = new JLabel("MENU");
        l8.setForeground(Color.WHITE);
        l8.setFont(new Font("monospaced",Font.BOLD,30));
        l8.setBounds(275, 200, 150, 30);
        add(l8);
        l8.setBackground(Color.WHITE);
        
               
        JLabel l9=new JLabel("ELECTRICITY BILLING SYSTEM");
        l9.setBackground(Color.WHITE);
        
        l9.setForeground(Color.WHITE);
        l9.setFont(new Font("monospaced",Font.BOLD,35));
        l9.setBounds(70, 100, 1000, 50);
        add(l9);
        
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon3/1.jpeg"));
        Image i5 = ic.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
        ImageIcon icc5 = new ImageIcon(i5);
        E = new JLabel(icc5);
        E.setBounds(1550, 800, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        add(E);
               
        setLayout(new BorderLayout());
        getContentPane().add(E);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
            
        }else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
            
        }else if(msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
            
        }else if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
           
        }else if(msg.equals("Note pad  ")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator  ")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);
            
        }else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }
        
        
    }
    
    
    public static void main(String[] args){
        new Sample1("", "Customer").setVisible(true);
    }
}