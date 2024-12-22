package bankmanagementsystem;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){                    //Constructor

        setLayout(null);
        setTitle("Automated Teller Machine");   //page title
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/images (1).png"));  //imageshow
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);   
        ImageIcon i3=new ImageIcon(i2);

        JLabel label1=new JLabel(i3);
        label1.setBounds(70, 10, 100, 100);    //adding
        add(label1);

        JLabel text=new JLabel("Welcome to ATM");         //
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(250, 40, 450, 40);
        add(text);

        JLabel cardno=new JLabel("Card No");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //Buttons
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGNUP");
        signup.setBounds(300,350 , 230, 30);
        signup.addActionListener(this);
        add(signup);




        getContentPane().setBackground(Color.WHITE);     //page background


        setSize(800,480);   //it defines frame size
        setVisible(true);               //it defines visible in window view
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'"; //matching data from database
            try{
                ResultSet rs=conn.s.executeQuery(query);    //storing data in resultset object it comes under sql libraries
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            }catch(Exception e){
            System.out.println(e);

            }

        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
        
    }

}