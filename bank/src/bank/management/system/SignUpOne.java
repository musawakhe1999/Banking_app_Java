//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


public class SignUpOne extends JFrame implements ActionListener{
JTextField nameInp,surnameInp,dob,emailInp,addressInp, stateInp,cityInp,pinCodeInp;
JButton next;
JRadioButton male,female, married,single;
    long random;
//ButtonGroup gender,maritalStatus;


    SignUpOne() {
        setTitle("Sign Up 1");

        this.setLayout((LayoutManager)null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/star.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, 1);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(30, 10, 100, 100);
        this.add(label);

//        this.setTitle("New Account Application Form");
//        JLabel heading = new JLabel("Application Form");
//        heading.setFont(new Font("Osward", 1, 38));
//        heading.setBounds(200, 40, 400, 40);
//        this.add(heading);


        Random ran =new Random();
         random=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formno=new JLabel("APPLICATION FORM NO:"+random);
        formno.setFont(new Font("Osward", 1, 24));
        formno.setBounds(180, 40, 400, 40);
        add(formno);


        JLabel heading2 = new JLabel("Page 1: Personal Details");
        heading2.setFont(new Font("Osward", 1, 20));
        heading2.setBounds(250, 80, 300, 30);
        this.add(heading2);

        JLabel name = new JLabel("Name:");
        name.setBounds(150, 150, 200, 50);
        this.add(name);

        nameInp = new JTextField();
        nameInp.setBounds(300, 155, 300, 30);
        this.add(nameInp);
        JLabel surname = new JLabel("Surname:");
        surname.setBounds(150, 180, 300, 50);
        this.add(surname);

       surnameInp = new JTextField();
        surnameInp.setBounds(300, 190, 300, 30);
        this.add(surnameInp);

        JLabel dob1 = new JLabel("Date of Birth:");
        dob1.setBounds(150, 220, 300, 50);
        this.add(dob1);

        dob = new JTextField();
        dob.setBounds(300, 230, 300, 30);
        this.add(dob);

        JLabel Gnd = new JLabel("Gender:");
        Gnd.setBounds(150, 260, 200, 50);
        this.add(Gnd);

        male = new JRadioButton("Male");
        male.setBounds(300, 270, 100, 30);
        this.add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 270, 120, 30);
        this.add(female);

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        JLabel emailAdd = new JLabel("Email Address:");
        emailAdd.setBounds(150, 305, 200, 50);
        this.add(emailAdd);

       emailInp = new JTextField();
        emailInp.setBounds(300, 320, 300, 30);
        this.add(emailInp);

        JLabel MStatus = new JLabel("Marital Status:");
        MStatus.setBounds(150, 350, 200, 50);
        this.add(MStatus);

     married = new JRadioButton("Married");
        married.setBounds(300, 360, 80, 30);
        this.add(married);

         single = new JRadioButton("Single");
        single.setBounds(400, 360, 150, 30);
        this.add(single);

        ButtonGroup maritalStatus = new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(single);

        JLabel address1 = new JLabel("Address:");
        address1.setBounds(150, 390, 200, 50);
        this.add(address1);

        addressInp = new JTextField();
        addressInp.setBounds(300, 400, 300, 30);
        this.add(addressInp);

        JLabel city1 = new JLabel("City:");
        city1.setBounds(150, 430, 200, 50);
        this.add(city1);

         cityInp = new JTextField();
        cityInp.setBounds(300, 440, 300, 30);
        this.add(cityInp);

        JLabel state1 = new JLabel("State:");
        state1.setBounds(150, 470, 200, 50);
        this.add(state1);

        stateInp = new JTextField();
        stateInp.setBounds(300, 480, 300, 30);
        this.add(stateInp);

        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setBounds(150, 510, 200, 50);
        this.add(pinCode);

       pinCodeInp = new JTextField();
        pinCodeInp.setBounds(300, 520, 300, 30);
        this.add(pinCodeInp);

         next = new JButton("Next");
        next.setBounds(500, 560, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        this.setSize(700, 700);
        this.setLocation(300, 70);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        String formno=""+random;
        String name=nameInp.getText();
        String surname=surnameInp.getText();
        String dateOfBirth=dob.getText();
        String gender=null;
        if (male.isSelected())
        {
            gender="Male";
        }else if (female.isSelected())
        {
            gender="Female";
        }
       String email=emailInp.getText();
        String address= addressInp.getText();
        String state=stateInp.getText();
        String city=cityInp.getText();
        String pinCode=pinCodeInp.getText();
        //if gives error check marital status
String marital=null;
if (single.isSelected())
{
    marital="Single";
}else if(married.isSelected())
{
    marital="Married";
}

try {
    if (name.equals(""))
    {
        JOptionPane.showMessageDialog(null,"Name is required");
    }
    else {
      Conn c=new Conn();

      String query="insert into signup values('"+formno+"','"+name+"','"+surname+"','"+dateOfBirth+"','"+gender+"','"+email+"','"+address+"','"+state+"','"+city+"','"+marital+"','"+pinCode+"')";
    c.s.executeUpdate(query);
    setVisible(false);
    new SignUpTwo(formno).setVisible(true);
    }

}catch (Exception e)
{
    System.out.println(e);
}


    }


    public static void main(String[] args) {
        new SignUpOne();
    }
}
