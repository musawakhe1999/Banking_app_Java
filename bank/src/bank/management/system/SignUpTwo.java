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


public class SignUpTwo extends JFrame implements ActionListener{
    JTextField qualInp;
    JButton next;
    JComboBox religionInp,incomeCategory,eduLevel;
long random;
    String formno;
    SignUpTwo(String formno) {
this.formno=formno;
//        Random ran =new Random();
//        random=Math.abs((ran.nextLong()%9000L)+1000L);
        setTitle("Sign Up 2");
        this.setLayout((LayoutManager)null);

        this.setTitle("New Account Application Form - Page 2");

        JLabel heading2 = new JLabel("Page 2: Additional Details");
        heading2.setFont(new Font("Osward", 1, 20));
        heading2.setBounds(250, 80, 300, 30);
        this.add(heading2);

        JLabel name = new JLabel("Religion:");
        name.setBounds(150, 150, 200, 50);
        this.add(name);


        String valReligion[]={"Christian","Hindu","Islam","Buddhism","Other"};
        religionInp=new JComboBox(valReligion);
        religionInp.setBounds(300, 155, 300, 30);
        religionInp.setBackground(Color.WHITE);
        this.add(religionInp);




        JLabel dob1 = new JLabel("Income:");
        dob1.setBounds(150, 190, 300, 50);

        this.add(dob1);


        String valIncome[]={"Null","<5000","<10 000","<15 000",">15 000"};

         incomeCategory = new JComboBox(valIncome);
        incomeCategory.setBounds(300, 200, 300, 30);
        incomeCategory.setBackground(Color.WHITE);
        this.add(incomeCategory);

        JLabel Gnd = new JLabel("Education:");
        Gnd.setBounds(150, 220, 300, 50);
        this.add(Gnd);


        String valEduaction[]={"Non-Grad","Graduate","Post-Graduate","Doctrate","Honours","Masters"};

        eduLevel = new JComboBox(valEduaction);
        eduLevel.setBounds(300, 240, 300, 30);
        eduLevel.setBackground(Color.WHITE);
        this.add(eduLevel);



        JLabel emailAdd = new JLabel("Qualification:");
        emailAdd.setBounds(150, 280, 200, 50);
        this.add(emailAdd);

        qualInp = new JTextField();
        qualInp.setBounds(300, 290, 300, 30);
        this.add(qualInp);


        next = new JButton("Next");
        next.setBounds(500, 360, 100, 30);
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
String qualification=qualInp.getText();
String religion= (String) religionInp.getSelectedItem();
String income=(String) incomeCategory.getSelectedItem();
String educationLevel=(String) eduLevel.getSelectedItem();
        try {
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+qualification+"','"+religion+"','"+income+"','"+educationLevel+"')";
                c.s.executeUpdate(query);

                //signup three object
            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        }catch (Exception e)
        {
            System.out.println(e);
        }


    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
