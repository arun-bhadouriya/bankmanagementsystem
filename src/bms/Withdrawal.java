package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdrawal(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i = img.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        img = new ImageIcon(i);
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(0,0,900,740);
        add(imageLabel);

        JLabel txt = new JLabel("Enter the amount you want to withdraw.");
        txt.setBounds(200,225,300,25);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(txt);

        amount = new JTextField();
        amount.setBounds(200,270,265,25);
        add(amount);

        withdraw = new JButton("Withdraw");
        back  = new JButton("Back");

        withdraw.setBounds(270+100,338+(28+5)*2-20,140,28);
        back.setBounds(270+100,338+(28+5)*3-20,140,28);

        withdraw.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);

        withdraw.addActionListener(this);
        back.addActionListener(this);

        imageLabel.add(withdraw);
        imageLabel.add(back);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Withdraw");
        setSize(900,740);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        if(e.getSource()==withdraw){
            String withdrawalAmt = amount.getText();
            Date date = new Date();
            String type ="withdraw";
            String pin = pinnumber;
            if(withdrawalAmt.equals("")) JOptionPane.showMessageDialog(null,"Please enter amount to withdraw.");
            else{
                Conn c = new Conn();
                String q ="INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','"+type+"','"+withdrawalAmt+"')";
                try{
                    c.s.executeUpdate(q);
                    c.con.close();
                    JOptionPane.showMessageDialog(null,"Withdrawal Successful.");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch(Exception e1) {
                    System.out.println(e1);
                }
            }

        }
    }
}
