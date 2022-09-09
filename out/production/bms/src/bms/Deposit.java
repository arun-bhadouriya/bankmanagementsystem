package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i = img.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        img = new ImageIcon(i);
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(0,0,900,740);
        add(imageLabel);

        JLabel txt = new JLabel("Enter the amount you want to deposit");
        txt.setBounds(200,225,300,25);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(txt);

        amount = new JTextField();
        amount.setBounds(200,270,265,25);
        add(amount);

        deposit = new JButton("Deposit");
        back  = new JButton("Back");

        deposit.setBounds(270+100,338+(28+5)*2-20,140,28);
        back.setBounds(270+100,338+(28+5)*3-20,140,28);

        deposit.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);

        deposit.addActionListener(this);
        back.addActionListener(this);

        imageLabel.add(deposit);
        imageLabel.add(back);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deposit");
        setSize(900,740);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        if(e.getSource()==deposit){
            String amt = amount.getText();
            Date date = new Date();
            String type = "deposit";

            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount you need to deposit");
                return;
            }

            Conn c = new Conn();
            try{
                String q ="INSERT INTO bank(pin,date,type,amount) VALUES('"+pinnumber+"','"+date+"','"+type+"','"+amt+"')";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Rs."+amt+" Deposited Successfully");
                c.con.close();
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception exc){
                System.out.println(exc);
            }
        }
    }
}
