package bms;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    int xPosition=125;
    int yPosition=70;
    int textFieldWidth = 350;
    JComboBox religionComboBox,categoryComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    JButton next;
    JRadioButton notExisting,existing,yes,no;
    JTextField aadharTextField,panTextField;
    Long formno;
    String[] religionsValues,categoriesValues,educationOptions,incomeOptions,occupationOptions;
    Signup2(Long formNum){
        setLayout(null);
        formno = formNum;
        setSize(750,730);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Registration Form");

        JLabel formno = new JLabel("APPLICATION FORM NO : "+formNum);
        formno.setBounds((750/2)+100,0,700,100);
        formno.setFont(new Font("Rale way",Font.BOLD,15));
        add(formno);

        JLabel page2 = new JLabel("Page 2: Additional Details");
        page2.setBounds(550/2,yPosition+50,700,50);
        page2.setFont(new Font("Arial",Font.BOLD,20));
        add(page2);

        JLabel religion = new JLabel("Religion: ");
        religion.setBounds(xPosition,yPosition+100,100,50);
        religion.setFont(new Font("Arial",Font.BOLD,14));
        add(religion);

        religionsValues= new String[]{"Select","Hindu", "Muslim", "Punjab", "Christian"};
        religionComboBox = new JComboBox<>(religionsValues);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setBounds(xPosition+150,yPosition+115,textFieldWidth,25);
        add(religionComboBox);

        JLabel category = new JLabel("Category: ");
        category.setBounds(xPosition,yPosition+140,150,50);
        category.setFont(new Font("Arial",Font.BOLD,14));
        add(category);

        categoriesValues = new String[]{"Select","General", "SC", "ST", "OBC"};
        categoryComboBox = new JComboBox<>(categoriesValues);
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setBounds(xPosition+150,yPosition+155,textFieldWidth,25);
        add(categoryComboBox);

        JLabel Income = new JLabel("Income: ");
        Income.setBounds(xPosition,yPosition+180,150,50);
        Income.setFont(new Font("Arial",Font.BOLD,14));
        add(Income);

        incomeOptions = new String[]{"Select","NULL", "Less Than 2 lacs", "Less Than 5 lacs", "More Than 5 lacs"};
        incomeComboBox = new JComboBox<>(incomeOptions);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(xPosition+150,yPosition+195,textFieldWidth,25);
        add(incomeComboBox);

        JLabel education = new JLabel("<html>Education <br>Qualification: </html>");
        education.setBounds(xPosition,yPosition+220,150,50);
        education.setFont(new Font("Arial",Font.BOLD,14));
        add(education);

        educationOptions = new String[]{"Select","10th", "12th", "Graduate", "PostGraduate", "Doctrate"};
        educationComboBox = new JComboBox<>(educationOptions);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setBounds(xPosition+150,yPosition+235,textFieldWidth,25);
        add(educationComboBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setBounds(xPosition,yPosition+260,textFieldWidth,50);
        occupation.setFont(new Font("Arial",Font.BOLD,14));
        add(occupation);

        occupationOptions = new String[]{"Select","Salaried", "Self-Employed", "Un-Employed", "Student", "Buisness", "Retire", "Others"};
        occupationComboBox = new JComboBox<>(occupationOptions);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(xPosition+150,yPosition+275,textFieldWidth,25);
        add(occupationComboBox);


        JLabel pan = new JLabel("PAN Number: ");
        pan.setBounds(xPosition,yPosition+300,150,50);
        pan.setFont(new Font("Arial",Font.BOLD,14));
        add(pan);

        panTextField = new JTextField();
        panTextField.setBounds(xPosition+150,yPosition+315,textFieldWidth,25);
        add(panTextField);

        JLabel adharNumber = new JLabel("Aadhar Number: ");
        adharNumber.setBounds(xPosition,yPosition+340,textFieldWidth,50);
        adharNumber.setFont(new Font("Arial",Font.BOLD,14));
        add(adharNumber);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(xPosition+150,yPosition+350,textFieldWidth,25);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setBounds(xPosition,yPosition+390,150,25);
        seniorCitizen.setFont(new Font("Arial",Font.BOLD,14));
        add(seniorCitizen);

        yes = new JRadioButton("Yes");
        yes.setBackground(Color.WHITE);
        yes.setBounds(xPosition+150,yPosition+390,100,25);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(xPosition+250,yPosition+390,100,25);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup isSeniorCitizen = new ButtonGroup();
        isSeniorCitizen.add(yes);
        isSeniorCitizen.add(no);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setBounds(xPosition,yPosition+420,150,50);
        existingAccount.setFont(new Font("Arial",Font.BOLD,14));
        add(existingAccount);

        existing = new JRadioButton("Yes");
        existing.setBackground(Color.WHITE);
        existing.setBounds(xPosition+150,yPosition+435,100,25);
        add(existing);
        notExisting = new JRadioButton("No");
        notExisting.setBounds(xPosition+250,yPosition+435,100,25);
        notExisting.setBackground(Color.WHITE);
        add(notExisting);
        ButtonGroup isExisting = new ButtonGroup();
        isExisting.add(existing);
        isExisting.add(notExisting);

        next = new JButton("Next");
        next.setBounds(xPosition+400,yPosition+520,100,30 );
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }
    static Signup2 s2;
    public static void main(String[] args) {
        s2 = new Signup2(1L);
        s2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion =religionsValues[religionComboBox.getSelectedIndex()];
        String category = categoriesValues[categoryComboBox.getSelectedIndex()];
        String income = incomeOptions[incomeComboBox.getSelectedIndex()];
        String education = educationOptions[educationComboBox.getSelectedIndex()];
        String occupation = occupationOptions[occupationComboBox.getSelectedIndex()];
        String pan = panTextField.getText();
        String adhaar = aadharTextField.getText();
        String seniorCitizen = null;
        if(yes.isSelected()) seniorCitizen="yes";
        else if(no.isSelected()) seniorCitizen="no";
        String existingAccount = null;
        if(existing.isSelected()) existingAccount="yes";
        else if(notExisting.isSelected()) existingAccount="no";
System.out.print(religion+" "+category+" "+income);
        if(religion=="Select" || category=="Select" || occupation=="Select" || income == "Select" || education == "Select") {
            JOptionPane.showMessageDialog(null, "Please Select All Fields.");
        }
        else if(pan=="" || adhaar=="" || seniorCitizen==null || existingAccount==null){
            JOptionPane.showMessageDialog(null, "Please input all fields.");
        }
        else{
            Conn c = new Conn();
            String query = "INSERT INTO additionalDetails VALUES( '"+formno+"','"+religion+"', '"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhaar+"','"+seniorCitizen+"','"+existingAccount+"')";
            try{
                c.s.executeUpdate(query);
                c.con.close();
                this.setVisible(false);
                new Signup3(formno).setVisible(true);
            }
            catch (Exception err){
                System.out.println(err);
            }
        }


    }
}
