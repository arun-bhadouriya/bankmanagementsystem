package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton a1,a2,a3,a4,a5,a6,back;
    String pinnumber;
    FastCash(String pin){
        this.pinnumber=pin;
        ImageIcon atmImage = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i1 = atmImage.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
        atmImage = new ImageIcon(i1);

        JLabel imageLabel = new JLabel(atmImage);
        imageLabel.setBounds(0,0,900,740);
        add(imageLabel);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(220,225,250,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(text);

        // button to display on the atm screen
        a1 = new JButton("Rs. 100");
        a1.setBackground(Color.WHITE);
        a1.setForeground(Color.BLACK);
        a1.setBounds(170,338,140,28);
        imageLabel.add(a1);

        a2 = new JButton("Rs. 500");
        a2.setBackground(Color.WHITE);
        a2.setForeground(Color.BLACK);
        a2.setBounds(270+100,338,140,28);
        imageLabel.add(a2);

        a3 = new JButton("Rs.1000");
        a3.setBackground(Color.WHITE);
        a3.setForeground(Color.BLACK);
        a3.setBounds(170,338+28+5,140,28);
        imageLabel.add(a3);

        a4 = new JButton("Rs. 2000");
        a4.setBackground(Color.WHITE);
        a4.setForeground(Color.BLACK);
        a4.setBounds(270+100,338+28+5,140,28);
        imageLabel.add(a4);

        a5 = new JButton("Rs. 5000");
        a5.setBackground(Color.WHITE);
        a5.setForeground(Color.BLACK);
        a5.setBounds(170,338+28+5+28+5,140,28);
        imageLabel.add(a5);

        a6 = new JButton("Rs. 10000");
        a6.setBounds(270+100,338+28+5+28+5,140,28);
        a6.setBackground(Color.WHITE);
        a6.setForeground(Color.BLACK);
        imageLabel.add(a6);

        back = new JButton("BACK");
        back.setBounds(270+100,338+(28+5)*3,140,28);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,14));
        back.setBackground(Color.WHITE);
        imageLabel.add(back);

        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);
        a5.addActionListener(this);
        a6.addActionListener(this);
        back.addActionListener(this);
        //end of buttons

        setTitle("Fast Cash");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(900,740);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        String amt = ((JButton)e.getSource()).getText().substring(4);
        Date date = new Date();
        String type = "withdraw";
        String pin = pinnumber;
        System.out.print(amt);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
            System.out.print(rs);
            int balance =0;
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            if(e.getSource()!= back && balance<Integer.parseInt(amt)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }

            String q ="INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','"+type+"','"+amt+"')";
            c.s.executeUpdate(q);
            c.con.close();
            JOptionPane.showMessageDialog(null,"Debited Successfully");
            this.setVisible(false);
            new Transaction(pin).setVisible(true);

        }catch (Exception e2){
            System.out.print(e2);
        }

    }
}
