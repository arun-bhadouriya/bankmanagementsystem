package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdraw, fastCash,statement, pinChange,exit,balanceEnquiry;
    String pinnumber;
    Transaction(String pin){
        this.pinnumber=pin;
        ImageIcon atmImage = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a1 = atmImage.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
        atmImage = new ImageIcon(a1);

        JLabel imageLabel = new JLabel(atmImage);
        imageLabel.setBounds(0,0,900,740);
        add(imageLabel);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220,225,250,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(text);

        // button to display on the atm screen
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(170,338,140,28);
        imageLabel.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setBounds(270+100,338,140,28);
        imageLabel.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.setBounds(170,338+28+5,140,28);
        imageLabel.add(fastCash);

        statement = new JButton("Mini Statement");
        statement.setBackground(Color.WHITE);
        statement.setForeground(Color.BLACK);
        statement.setBounds(270+100,338+28+5,140,28);
        imageLabel.add(statement);

        pinChange = new JButton("Pin Change");
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.setBounds(170,338+28+5+28+5,140,28);
        imageLabel.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(270+100,338+28+5+28+5,140,28);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.setForeground(Color.BLACK);
        imageLabel.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(270+100,338+(28+5)*3,140,28);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        imageLabel.add(exit);

        deposit.addActionListener(this);
        exit.addActionListener(this);
        balanceEnquiry.addActionListener(this);
        pinChange.addActionListener(this);
        withdraw.addActionListener(this);
        fastCash.addActionListener(this);
        statement.addActionListener(this);



        //end of buttons
        setTitle("Transactions");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(900,740);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    public static void main(String[] args) {
        new Transaction("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        if(e.getSource()==withdraw){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        if(e.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
    }
}
