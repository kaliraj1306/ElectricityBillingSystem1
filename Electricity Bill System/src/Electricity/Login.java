package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l4,E,l5,tf3,l6;
    JTextField tf1,tf2;
    JPasswordField pf2;
    JButton b1,b2, b3;
    Choice c1;
    Login(){
        super("Login Page");        
        l1 = new JLabel("USERNAME");
        l1.setBounds(900, 300, 150, 30);
        add(l1);
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("PASSWORD");
        l2.setBounds(900, 360, 150, 30);
        add(l2);
        l2.setForeground(Color.WHITE);
        
        tf1 = new JTextField(15);
        tf1.setBounds(1000, 300, 250, 30);
        add(tf1);
        tf1.setFont(new Font("monospaced",Font.BOLD,15));
        
        
        pf2 = new JPasswordField(15);
        pf2.setBounds(1000, 360, 250, 30);
        add(pf2);
        
        l4 = new JLabel("L0GIN AS");
        l4.setBounds(900, 420, 100, 30);
        add(l4);
        l4.setForeground(Color.WHITE);
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(1000, 425, 250,50);
        add(c1);
        c1.setFont(new Font("monospaced",Font.BOLD,13));
        
        tf2 = new JTextField();
        tf2.setBounds(1000, 480, 125, 30);
        add(tf2);
        tf2.setFont(new Font("monospaced",Font.BOLD,20));
        
        Captcha k=new Captcha();
        String msg=k.Captcha1();
        tf3 = new JLabel(msg);
        tf3.setBounds(1150, 480, 125, 30);
        add(tf3);
        tf3.setFont(new Font("monospaced",Font.BOLD,20));
        tf3.setForeground(Color.WHITE);
        tf3.setBackground(Color.WHITE);
        
        
        l5=new JLabel("CAPTCHA");
        l5.setBounds(900, 480, 100, 30);
        add(l5);
        l5.setForeground(Color.WHITE);
        
        l6=new JLabel("ELECTRICITY BILLING SYSTEM");
        l6.setBackground(Color.WHITE);
        add(l6);
        l6.setBounds(800, 150, 1000, 50);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("monospaced",Font.BOLD,40));
        
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(930, 550, 150, 25);
        b1.setBackground(Color.WHITE);
        
        add(b1);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i2));
        b2.setBounds(1100, 550, 150, 25);
        add(b2);
        b2.setBackground(Color.WHITE);
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b3 = new JButton("Signup",new ImageIcon(i4));
        b3.setBounds(980, 600, 150, 25);
        add(b3);
        b3.setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);


        /*ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        add(l3);*/
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon2/13.jpeg"));
        Image i5 = ic.getImage().getScaledInstance(1550, 870,Image.SCALE_DEFAULT);
        ImageIcon icc5 = new ImageIcon(i5); 
        E = new JLabel(icc5);
        E.setBounds(1550, 860, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        add(E);
        
        setLayout(new BorderLayout());
        getContentPane().add(E);
    
     
        setSize(1550,870);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try
            {        
                String u=tf3.getText();
                String v=tf2.getText();
                
                Conn c = new Conn(); 
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem();
                if(u.contentEquals(v))
                {
                if(user.contentEquals("Admin"))
                {
                    String w  = "SELECT * FROM `admin` WHERE username='"+a+"' and password='"+b+"' and user='"+user+"'";
                    ResultSet ra = c.s.executeQuery(w);
                    if(ra.next())
                    {
                        String meter1 =null;
                        new Sample1(meter1,user).setVisible(true);
                        this.setVisible(false);
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                    }
                }
                if(user.contentEquals("Customer"))
                {
                    String q  = "SELECT * FROM `login` WHERE username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next()){
                        String meter2 = rs.getNString("meter_no");
                        new Sample2(meter2, user).setVisible(true);
                        this.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        tf1.setText("");
                        pf2.setText("");
                    }
                }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "WRONG CAPTCHA");
                }
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}
    
/*public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                Conn c = new Conn();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem();
                String q  = "select * from login where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter="null"; 
                    meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}*/




