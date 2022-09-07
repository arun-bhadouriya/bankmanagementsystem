package bms;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup1 extends JFrame implements ActionListener {
    int xPosition=125;
    int yPosition=70;
    int textFieldWidth = 350;
    JTextField nameField,FatherNameField,emailField,addressField,cityField,stateField,pinField;
    JButton next;
    JLabel gender;
    JRadioButton male,female,marital1,marital2,marital3;
    JDateChooser dobPicker;
    Long randomFormNum;
    Signup1(){
        setLayout(null);

        setSize(750,730);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SignUp");

        Random randomFormno = new Random();
        randomFormNum = Math.abs(randomFormno.nextLong()%9000L + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO : "+randomFormNum);
        formno.setBounds((750/2)+100,0,700,100);
        formno.setFont(new Font("Rale way",Font.BOLD,15));
        add(formno);

        JLabel page1 = new JLabel("Page:1 Personal Details");
        page1.setBounds(550/2,yPosition+50,700,50);
        page1.setFont(new Font("Arial",Font.BOLD,20));
        add(page1);

        JLabel name = new JLabel("Name: ");
        name.setBounds(xPosition,yPosition+100,100,50);
        name.setFont(new Font("Arial",Font.BOLD,14));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(xPosition+150,yPosition+115,textFieldWidth,25);
        add(nameField);

        JLabel FatherName = new JLabel("Father's Name: ");
        FatherName.setBounds(xPosition,yPosition+140,150,50);
        FatherName.setFont(new Font("Arial",Font.BOLD,14));
        add(FatherName);

        FatherNameField = new JTextField();
        FatherNameField.setBounds(xPosition+150,yPosition+155,textFieldWidth,25);
        add(FatherNameField);

        JLabel dateOfBirth = new JLabel("Date Of Birth: ");
        dateOfBirth.setBounds(xPosition,yPosition+180,150,50);
        dateOfBirth.setFont(new Font("Arial",Font.BOLD,14));
        add(dateOfBirth);

        dobPicker = new JDateChooser();
        dobPicker.setBounds(xPosition+150,yPosition+190,textFieldWidth,25);
        dobPicker.setBackground(Color.WHITE);
        add(dobPicker);

        gender = new JLabel("Gender: ");
        gender.setBounds(xPosition,yPosition+220,150,50);
        gender.setFont(new Font("Arial",Font.BOLD,14));
        add(gender);

        male = new JRadioButton("male");
        male.setBounds(xPosition+150,yPosition+235,80,25);
        male.setFont(new Font("Arial",Font.BOLD,14));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("female");
        female.setBounds(xPosition+240,yPosition+235,100,25);
        female.setFont(new Font("Arial",Font.BOLD,14));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email: ");
        email.setBounds(xPosition,yPosition+260,textFieldWidth,50);
        email.setFont(new Font("Arial",Font.BOLD,14));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(xPosition+150,yPosition+270,textFieldWidth,25);
        add(emailField);


        JLabel marital = new JLabel("Marital Status: ");
        marital.setBounds(xPosition,yPosition+300,150,50);
        marital.setFont(new Font("Arial",Font.BOLD,14));
        add(marital);

        marital1 = new JRadioButton("married");
        marital1.setBounds(xPosition+150,yPosition+310,80,25);
        marital1.setFont(new Font("Arial",Font.BOLD,14));
        marital1.setBackground(Color.WHITE);
        add(marital1);

        marital2 = new JRadioButton("single");
        marital2.setBounds(xPosition+240,yPosition+310,80,25);
        marital2.setFont(new Font("Arial",Font.BOLD,14));
        marital2.setBackground(Color.WHITE);
        add(marital2);

        marital3 = new JRadioButton("divorced");
        marital3.setBounds(xPosition+330,yPosition+310,100,30);
        marital3.setFont(new Font("Arial",Font.BOLD,14));
        marital3.setBackground(Color.WHITE);
        add(marital3);

        ButtonGroup maritalbuttons = new ButtonGroup();
        maritalbuttons.add(marital1);
        maritalbuttons.add(marital2);
        maritalbuttons.add(marital3);

        JLabel address = new JLabel("Address: ");
        address.setBounds(xPosition,yPosition+340,textFieldWidth,50);
        address.setFont(new Font("Arial",Font.BOLD,14));
        add(address);

        addressField = new JTextField();
        addressField.setBounds(xPosition+150,yPosition+350,textFieldWidth,25);
        add(addressField);

        JLabel city = new JLabel("City: ");
        city.setBounds(xPosition,yPosition+380,150,50);
        city.setFont(new Font("Arial",Font.BOLD,14));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(xPosition+150,yPosition+390,textFieldWidth,25);
        add(cityField);

        JLabel state = new JLabel("State: ");
        state.setBounds(xPosition,yPosition+420,150,50);
        state.setFont(new Font("Arial",Font.BOLD,14));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(xPosition+150,yPosition+430,textFieldWidth,25);
        add(stateField);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setBounds(xPosition,yPosition+460,150,50);
        pinCode.setFont(new Font("Arial",Font.BOLD,14));
        add(pinCode);

        pinField = new JTextField();
        pinField.setBounds(xPosition+150,yPosition+470,textFieldWidth,25);
        add(pinField);
        
        next = new JButton("Next");
        next.setBounds(xPosition+400,yPosition+520,100,30 );
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setDefaultLookAndFeelDecorated(true);

    }
    static Signup1 s1;
    public static void main(String[] args) {
        s1 =new Signup1();
        s1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String father = FatherNameField.getText();
        String email = emailField.getText();
        String gender =null;
        if(male.isSelected()) gender = "male";
        else if(female.isSelected()) gender = "female";
        String maritalStatus = null;
        if(marital1.isSelected()) maritalStatus="married";
        else if(marital2.isSelected()) maritalStatus = "Single";
        else if(marital3.isSelected()) maritalStatus = "Divorced";
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinField.getText();
        String dob =((JTextField)dobPicker.getDateEditor().getUiComponent()).getText();

        if(dobPicker.getDate()==null || name=="" || gender == null || maritalStatus==null || father =="" || email=="" || address=="" || city=="" || state=="" || pin=="") {
                JOptionPane.showMessageDialog(null, "Please input all fields.");
        }
        else{
            Conn c = new Conn();
            String query = "INSERT INTO signup VALUES( '"+randomFormNum+"', '"+name+"','"+father+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            try{
                c.s.executeUpdate(query);
                c.con.close();
                this.setVisible(false);
                Signup2 s2 = new Signup2(randomFormNum);
                s2.setVisible(true);
            }
            catch (Exception err){
                System.out.println(err);
            }
        }
    }
}
