package bankmanagementsystem; // this is userdefined package
import javax.swing.*;  //this is for JFrame
import java.awt.*; //this is for Image font color etc
import java.awt.event.*; //this library is for implementing actionListner

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrwal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;

    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(890, 820, Image.SCALE_DEFAULT);   
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 890, 820);    //adding
        add(image);

        JLabel text= new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,375,150,28);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrwal=new JButton("Cash Withdrwal");
        withdrwal.setBounds(355,375,150,28);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,410,150,28);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,410,150,28);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("PIN Change");
        pinchange.setBounds(170,445,150,28);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,443,150,28);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrwal){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Transaction("");
        
    }
}
