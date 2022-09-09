package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton close;
    MiniStatement(String pin){
        this.pin = pin;
        setLayout(null);

        JLabel cardNumber = new JLabel("Card Number : ");
        cardNumber.setFont(new Font("System",Font.BOLD,12));
        cardNumber.setBounds(160,20,210,40);
        add(cardNumber);




        try{
            Conn c1 = new Conn();
            String s = "SELECT * FROM login where pin = '"+pin+"'";

            ResultSet rs = c1.s.executeQuery(s);

            while(rs.next()){
                String x = rs.getString("card_number");
                cardNumber.setText(cardNumber.getText()+x.substring(0,4)+"XXXXXXXX"+x.substring(12));
            }
            c1.con.close();
        }catch(Exception ec){
            System.out.print(ec);
        }

        try{
            Conn c = new Conn();
            String query = "SELECT * FROM bank where pin = '"+pin+"' ORDER BY date DESC";
            ResultSet rs = c.s.executeQuery(query);
            JLabel statement = new JLabel();
            int balance = 0;
            String txt[] = new String[6];
            int i=0;
            while(rs.next()){
                if(i<6)
                    txt[i++]=rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>";
                if(rs.getString("type").equals("deposit")) balance+=Integer.parseInt(rs.getString("amount"));
                else if(rs.getString("type").equals("withdraw")) balance-=Integer.parseInt(rs.getString("amount"));
          }
            String miniStatement = "";
            for(int j = 0; j<6; j++){
                miniStatement+=txt[j];
            }
            statement.setText("<html>"+miniStatement+"</html>");
            statement.setBounds(30,80,400,250);
            add(statement);
            JLabel bal = new JLabel("Current Balance : "+balance);
            bal.setBounds(30,300,400,30);
            add(bal);
        }catch (Exception ec){
            System.out.println(ec);
        }


        close = new JButton("CLOSE");
        close.setBounds(230,500,100,30);
        close.addActionListener(this);
        add(close);

        setUndecorated(true);
        setTitle("Mini Statement");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocation(20,20);
        this.getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
//        new MiniStatement("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            this.setVisible(false);
        }
    }
}
