package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton back,change;
    JTextField newPinText,rePinText;
    String pinNumber;
    PinChange(String pin){
        this.pinNumber = pin;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        img = new ImageIcon(i1);

        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(0,0,900,850);
        add(imageLabel);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,220,150,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        Component add = imageLabel.add(text);

        JLabel newPin = new JLabel("New PIN ");
        newPin.setBounds(165,250,100,25);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(newPin);

        newPinText = new JTextField();
        newPinText.setBounds(320,250,180,20);
        newPinText.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(newPinText);

        JLabel rePin = new JLabel("Re-Enter New PIN");
        rePin.setBounds(165,300,250,25);
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(rePin);

        rePinText = new JTextField();
        rePinText.setBounds(320,300,180,20);
        rePinText.setFont(new Font("System",Font.BOLD,14));
        imageLabel.add(rePinText);

        change = new JButton("CHANGE");
        back = new JButton("BACK");
        change.setFont(new Font("System",Font.BOLD,14));
        back.setFont(new Font("System",Font.BOLD,14));
        change.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        back.addActionListener(this);
        change.setBounds(350,385,150,25);
        back.setBounds(350,415,150,25);
        imageLabel.add(change);
        imageLabel.add(back);

        setUndecorated(true);
        setSize(900,740);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else if(e.getSource()==change){
            if(newPinText.getText().equals("") || rePinText.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter PIN");
                return;
            }
            else{
                String pin = newPinText.getText();
                String rpin = rePinText.getText();
                if(!pin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                else if(pin.equals(rpin) && (pin.length()<4 || pin.length()>4)){
                    JOptionPane.showMessageDialog(null,"PIN should be of length 4");
                    return;
                }
                Conn c = new Conn();
                try{
                    String q = "UPDATE login SET pin='"+pin+"' WHERE pin='"+pinNumber+"'";
                    String q1 = "UPDATE bank SET pin='"+pin+"' WHERE pin='"+pinNumber+"'";
                    String q2 = "UPDATE accounttype SET pin='"+pin+"' WHERE pin='"+pinNumber+"'";
                    System.out.println(q);
                    c.s.executeUpdate(q);
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.con.close();
                    JOptionPane.showMessageDialog(null,"PIN Successfully UPDATED");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch(Exception exc2){
                    System.out.print(exc2);
                }
            }

        }
    }
}
