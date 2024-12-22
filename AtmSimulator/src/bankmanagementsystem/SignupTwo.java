package bankmanagementsystem;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements  ActionListener{

    JTextField nameTextField,fTextField, emailTextField,panTextField,aadharTextField,pinTextField,stateTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occuption,education;
    String formno;

    SignupTwo(String formno) {
        this.formno=formno;



        setLayout(null);
        setTitle("New Account Application Form-Page 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);


        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valCategory[]={"General","OBC","SC","ST","Others"};
        category= new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        add(category);


        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        String valIncome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","UpTo 10,00,000"};
        income= new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        add(income);


        JLabel gender = new JLabel("Educational :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        String eduactionValues[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education= new JComboBox(eduactionValues);
        education.setBounds(300,310,400,30);
        add(education);

        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        String occupationValues[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occuption= new JComboBox(occupationValues);
        occuption.setBounds(300,390,400,30);
        add(occuption);


        JLabel address = new JLabel("PAN Number :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel city = new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        ButtonGroup maritaalGroup = new ButtonGroup();
        maritaalGroup.add(syes);
        maritaalGroup.add(sno);


        JLabel pincode = new JLabel("Existing Account :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);


        JButton next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seduaction=(String) education.getSelectedItem();
        String soccupation=(String) occuption.getSelectedItem();
        String seniorCitizen="";
        if(syes.isSelected()){
            seniorCitizen="Yes";
        }else if(sno.isSelected()){
            seniorCitizen="No";
        }

        String existingAccount="";
        if(eyes.isSelected()){
            existingAccount="Yess";
        }else if(eno.isSelected()){
            existingAccount="No";
        }

        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();


        try{
            Conn c=new Conn();
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seduaction+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
            c.s.executeUpdate(query);

            //SignupThree Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        

    }

    public static void main(String[] args) {
        new SignupTwo("");

    }
}

