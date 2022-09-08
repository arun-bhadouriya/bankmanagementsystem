package bms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    ImageIcon logo;
    JLabel logoLabel;
    JButton clearTextField,logIn,signUp;
    JTextField cardInput,pinInput;
    Login(){
        setTitle("BMS");
        setSize(700,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image logo2 = logo.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        logo = new ImageIcon(logo2);
        logoLabel = new JLabel(logo);
        setLayout(null);
        logoLabel.setBounds(80,10,logo.getIconWidth(), logo.getIconHeight());
        add(logoLabel);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("WELCOME TO ATM MACHINE");
        l1.setBounds(200,40,680,50);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        add(l1);

        JLabel user = new JLabel("Card No: ");
        user.setBounds(180,120,100,50);
        user.setFont(new Font("Arial",Font.BOLD,20));
        add(user);

        JLabel pin = new JLabel("Pin: ");
        pin.setBounds(180,180,100,50);
        pin.setFont(new Font("Arial",Font.BOLD,20));
        add(pin);


        logIn = new JButton("LOGIN");
        logIn.setBounds(300,250,100,30);
        logIn.setBackground(Color.BLACK);
        logIn.setForeground(Color.WHITE);
        logIn.addActionListener(this);
        add(logIn);

        clearTextField = new JButton("CLEAR");
        clearTextField.setBounds(430,250,100,30);
        clearTextField.setBackground(Color.BLACK);
        clearTextField.setForeground(Color.WHITE);
        add(clearTextField);
        clearTextField.addActionListener(this);

        signUp = new JButton("SIGNUP");
        signUp.setBounds(300,290,230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        cardInput = new JTextField();
        pinInput = new JPasswordField();
        cardInput.setBounds(300,130,230,30);
        cardInput.setFont(new Font("Arial",Font.BOLD,15));
        pinInput.setBounds(300,190,230,30);
        pinInput.setFont(new Font("Arial",Font.BOLD,15));
        add(pinInput);
        add(cardInput);

        setUndecorated(false);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clearTextField){
            cardInput.setText("");
            pinInput.setText("");
        }
        else if(e.getSource()==signUp){
            setVisible(false);
            new Signup1().setVisible(true);
        }
        else if(e.getSource()==logIn){
            Conn c = new Conn();
            String cardNumber = cardInput.getText();
            String pinNumber = pinInput.getText();

            String query = "SELECT * FROM login WHERE card_number='"+cardNumber+"' AND pin='"+pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Card Number / Password");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
