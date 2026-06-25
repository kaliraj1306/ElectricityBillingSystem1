 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1, t2, t3, t4;
    Choice c1;
    JPasswordField o;
    JButton b1, b2;
    JLabel E,E1,l6,l7;
    
    Signup(){
        setTitle("SIGNUP");
        setSize(1550,870);
        
        /*p1 = new JPanel();
        p1.setBounds(200, 200, 650, 400);
        p1.setLayout(null);
        p1.setBackground(null);
        p1.setForeground(new Color(34, 139, 34));
       // p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);*/
        
        JLabel l1 = new JLabel("USERNAME");
        l1.setForeground(Color.WHITE);  
        l1.setBounds(300, 300, 150, 30);
        add(l1);
        l1.setFont(new Font("monospaced",Font.BOLD,16));
        
        t1 = new JTextField();
        t1.setBounds(450, 300, 230, 30);
        t1.setFont(new Font("monospaced", Font.BOLD, 16));
        add(t1);
        
        JLabel l2 = new JLabel("NAME");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("monospaced",Font.BOLD,16));
        l2.setBounds(300, 360, 150, 30);
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(450, 360, 230, 30);
        t2.setFont(new Font("monospaced", Font.BOLD, 16));
        add(t2);
        
        
        JLabel l3 = new JLabel("PASSWORD");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("monospaced",Font.BOLD,16));
        l3.setBounds(300, 420, 150, 30);
        add(l3);
        
        o = new JPasswordField();
        o.setBounds(450, 420, 230, 30);
        add(o);
        
        
        JLabel l4 = new JLabel("SIGNUP AS");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("monospaced",Font.BOLD,16));       
        l4.setBounds(300, 480, 150, 30);
        add(l4);
        
        
        JLabel l5 = new JLabel("METER NUMBER");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("monospaced",Font.BOLD,16));
        l5.setBounds(300, 540, 150, 30);
        l5.setVisible(false);
        add(l5);
        
        t4 = new JTextField();
        t4.setBounds(450, 540, 230, 30);
        t4.setFont(new Font("monospaced", Font.BOLD, 16));
        t4.setVisible(false);
        add(t4);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(450, 485, 230,50);
        add(c1);
        c1.setFont(new Font("monospaced",Font.BOLD,13));
        
        JLabel l7 = new JLabel("SIGN UP");
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("monospaced",Font.BOLD,30));
        l7.setBounds(420, 200, 150, 30);
        add(l7);
        
        
                       
        c1.addItemListener((ItemEvent ae) -> {
            String user = c1.getSelectedItem();
            if(user.equals("Customer")){
                l5.setVisible(true);
                t4.setVisible(true);
            }else{
                l5.setVisible(false);
                t4.setVisible(false);
            } 
        });
        
        
        b1 = new JButton("CREATE");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(330, 610, 150, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setBounds(500, 610, 150, 25);
        b2.addActionListener(this);
        add(b2);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(460, 130, 40,40);
        add(l6);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon2/17.jpeg"));
        Image i5 = ic.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
        ImageIcon icc5 = new ImageIcon(i5);
        E = new JLabel(icc5);
        E.setBounds(1550, 800, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        add(E);
        
        /*ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i1 = ic1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon icc6 = new ImageIcon(i1);
        E1=new JLabel(icc6);
        E1.setBounds(375, 300, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        E1.setBackground(Color.WHITE);
        add(E1);*/
        
        
        setLayout(new BorderLayout());
        getContentPane().add(E);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = null;
            username=t1.getText();
            String name = t2.getText();
            String password = o.getText();
            String user = c1.getSelectedItem();
            String meter1 = t4.getText();
            try{
                Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                str="INSERT INTO `admin` (`username`, `name`, `password`, `user`) VALUES ('"+username+"', '"+name+"', '"+password+"', '"+user+"');";
                }
                else{
                    str="INSERT INTO `login`(`meter_no`, `name`, `username`, `password`, `user`) VALUES ('"+meter1+"','"+name+"','"+username+"','"+password+"','"+user+"')";
                }                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                
            }
        } else if(ae.getSource()== b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
    
     