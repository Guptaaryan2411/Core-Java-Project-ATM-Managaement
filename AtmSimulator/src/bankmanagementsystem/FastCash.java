package bankmanagementsystem; // this is userdefined package
import javax.swing.*;  //this is for JFrame
import java.awt.*; //this is for Image font color etc
import java.awt.event.*; //this library is for implementing actionListner
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrwal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(890, 820, Image.SCALE_DEFAULT);   
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 890, 820);    //adding
        add(image);

        JLabel text= new JLabel("Select Withdrawl Ammount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(170,375,150,28);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrwal=new JButton("Rs 500");
        withdrwal.setBounds(355,375,150,28);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,410,150,28);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,410,150,28);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,445,150,28);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(355,443,150,28);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("BACK");
        exit.setBounds(355,472,150,28);
        exit.addActionListener(this);
        image.add(exit);

        


        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c= new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select *from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date= new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+"  Debited Sucessfull");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        new FastCash("");
        
    }
}
