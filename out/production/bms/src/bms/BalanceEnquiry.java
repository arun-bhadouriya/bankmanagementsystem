package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pin;
    int balance = 0;
    BalanceEnquiry(String pin){
        this.pin = pin;
        setSize(900,740);
        setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        img = new ImageIcon(i1);

        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(0,0,900,740);
        add(imageLabel);

        back = new JButton("Back");
        back.setBounds(355,400,150,30);
        back.setFont(new Font("System",Font.BOLD,14));
        back.addActionListener(this);
        imageLabel.add(back);

        Conn c = new Conn();
        String q = "SELECT * FROM bank where pin='"+pin+"'";
        try{
            ResultSet rs = c.s.executeQuery(q);

            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else if(rs.getString("type").equals("withdraw")){
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception ec){
            System.out.println(ec);
        }

        JLabel text = new JLabel("Your current Account balance is Rs. " +balance);
        text.setBounds(170,250,400,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        imageLabel.add(text);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BalanceEnquiry");
        setUndecorated(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
}
