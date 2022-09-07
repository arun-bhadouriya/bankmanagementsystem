package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    Long formno;
    int xPosition=150;
    int yPosition=50;
    JRadioButton savings,recurring,fd,current;
    JCheckBox atmCard,miniStatement,chequeBook,emailAndSms,mobileBanking,internetBanking,declaration;
    JButton submit,cancel;
    Signup3(Long formNum) {
        formno = formNum;
        setDefaultLookAndFeelDecorated(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,730);
        this.getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel formDetails = new JLabel("APPLICATION FORM NO : "+formNum);
        formDetails.setBounds((750/2)+100,0,700,100);
        formDetails.setFont(new Font("Rale way",Font.BOLD,15));
        add(formDetails);

        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setBounds(550/2,yPosition+50,700,50);
        page3.setFont(new Font("Raleway",Font.BOLD,20));
        add(page3);

        JLabel accountType = new JLabel("Account Type ");
        accountType.setBounds(xPosition,yPosition+100,250,25);
        accountType.setFont(new Font("Raleway",Font.BOLD,20));
        add(accountType);

        savings = new JRadioButton("Savings Account");
        fd = new JRadioButton("Fixed Deposit Account");
        current = new JRadioButton("Current Account");
        recurring = new JRadioButton("Recurring Deposit Account");

        savings.setBounds(xPosition+5,yPosition+130,150,25);
        fd.setBounds(xPosition+225,yPosition+130,180,25);
        current.setBounds(xPosition+5,yPosition+155,150,25);
        recurring.setBounds(xPosition+225,yPosition+155,180,25);

        savings.setBackground(Color.WHITE);
        fd.setBackground(Color.WHITE);
        current.setBackground(Color.WHITE);
        recurring.setBackground(Color.WHITE);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savings);
        accountTypeGroup.add(current);
        accountTypeGroup.add(fd);
        accountTypeGroup.add(recurring);

        add(savings);
        add(fd);
        add(current);
        add(recurring);

        JLabel cardNumber = new JLabel("Card Number");
        JLabel cardNumberTxt = new JLabel("Your 16 digits Card Number");

        cardNumber.setBounds(xPosition,yPosition+210,150,25);
        cardNumber.setFont(new Font("Arial",Font.BOLD,20));
        cardNumberTxt.setBounds(xPosition,yPosition+230,200,25);
        cardNumberTxt.setFont(new Font("Arial",Font.PLAIN,10));

        add(cardNumber);
        add(cardNumberTxt);

        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-4182");
        cNumber.setBounds(xPosition+200,yPosition+210,250,25);
        cNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(cNumber);

        JLabel pin = new JLabel("PIN");
        JLabel pinTxt = new JLabel("Your 4 digits Password");

        pin.setBounds(xPosition,yPosition+270,150,25);
        pin.setFont(new Font("Arial",Font.BOLD,20));
        pinTxt.setBounds(xPosition,yPosition+290,200,25);
        pinTxt.setFont(new Font("Arial",Font.PLAIN,10));

        add(pin);
        add(pinTxt);

        //write logic to generate atm and pin number
        JLabel generatedPin = new JLabel("XXXX");
        generatedPin.setBounds(xPosition+200,yPosition+265,100,25);
        generatedPin.setFont(new Font("Raleway",Font.BOLD,20));
        add(generatedPin);

        JLabel services = new JLabel("Services Required");
        services.setBounds(xPosition,yPosition+330,200,25);
        services.setFont(new Font("Arial",Font.BOLD,20));
        add(services);

        atmCard = new JCheckBox("ATM CARD");
        internetBanking = new JCheckBox("Internet Banking");
        mobileBanking = new JCheckBox("Mobile Banking");
        emailAndSms = new JCheckBox("Email & SMS");
        chequeBook = new JCheckBox("Cheque Book");
        miniStatement = new JCheckBox("Mini Statement");

        atmCard.setBounds(xPosition+5,yPosition+360,150,25);
        internetBanking.setBounds(xPosition+225,yPosition+360,150,25);
        mobileBanking.setBounds(xPosition+5,yPosition+395,150,25);
        emailAndSms.setBounds(xPosition+225,yPosition+395,150,25);
        chequeBook.setBounds(xPosition+5,yPosition+430,150,25);
        miniStatement.setBounds(xPosition+225,yPosition+430,150,25);

        atmCard.setBackground(Color.WHITE);
        internetBanking.setBackground(Color.WHITE);
        mobileBanking.setBackground(Color.WHITE);
        emailAndSms.setBackground(Color.WHITE);
        chequeBook.setBackground(Color.WHITE);
        miniStatement.setBackground(Color.WHITE);
        add(atmCard);
        add(internetBanking);
        add(mobileBanking);
        add(emailAndSms);
        add(chequeBook);
        add(miniStatement);

        declaration = new JCheckBox(" I herby decalare that above enetered details are correct to the best of my knowledge");
        declaration.setBounds(xPosition,yPosition+500,this.getWidth(),25);
        declaration.setBackground(Color.WHITE);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(xPosition,yPosition+550,100,25);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(xPosition+150,yPosition+550,100,25);
        add(cancel);

        cancel.addActionListener(this);
        submit.addActionListener(this);
    }

    public static void main(String[] args) {
        new Signup3(1L).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType = null;
            if(savings.isSelected()) accountType="savings";
            else if(fd.isSelected()) accountType="fixed deposit";
            else if(recurring.isSelected()) accountType="recurring deposit";
            else if(current.isSelected()) accountType="current Account";

            Random r = new Random();
            String randomNum = "" +(Math.abs((r.nextLong()%90000000L) + 5040936000000000L));
            System.out.println(randomNum);

            String pin  ="" + Math.abs(r.nextInt(9999));
            System.out.println(pin);

            String servicesRequired = "";
            if(atmCard.isSelected()) servicesRequired+=" ATM Card ";
            if(mobileBanking.isSelected()) servicesRequired+=" Mobile Banking ";
            if(chequeBook.isSelected()) servicesRequired+=" Cheque Book ";
            if(internetBanking.isSelected()) servicesRequired+= " Internet Banking ";
            if(emailAndSms.isSelected()) servicesRequired+=" Email & SMS ";
            if(miniStatement.isSelected()) servicesRequired+= " Mini Statement ";

            if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null,"Please check declaration.");
            }
            else if(servicesRequired.equals("")){
                JOptionPane.showMessageDialog(null,"Please Select the required services");
            }
            else if(accountType==null){
                JOptionPane.showMessageDialog(null,"Select the Account Type");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query = "INSERT INTO accountType VALUES( '"+formno+"','"+accountType+"', '"+randomNum+"','"+pin+"','"+servicesRequired+"')";
                    c.s.executeUpdate(query);
                    String query2 = "INSERT INTO login VALUES( '"+formno+"', '"+randomNum+"','"+pin+"')";
                    c.s.executeUpdate(query2);
                    c.con.close();
                    JOptionPane.showMessageDialog(null,"Card Number: "+randomNum+"\n"+"Pin: "+pin);

                    setVisible(false);
                    new Deposit(pin).setVisible(true);

                }catch (Exception er){
                    System.out.print(er);
                }
            }

        }
        if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
