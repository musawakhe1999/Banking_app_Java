//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton clear;
    JButton login;
    JButton signUp;
    JTextField cardNum;
    JPasswordField pinNum;

    Login() {
        setTitle("Login");
        this.setLayout((LayoutManager)null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/star.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, 1);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(70, 10, 100, 100);
        this.add(label);
        JLabel heading = new JLabel("Welcome to Batlokwa ATM");
        heading.setFont(new Font("Osward", 1, 20));
        heading.setBounds(200, 40, 400, 40);
        this.add(heading);
        JLabel cardNo = new JLabel("Card No");
        cardNo.setFont(new Font("Osward", 1, 20));
        cardNo.setBounds(150, 190, 400, 40);
        this.add(cardNo);
        this.cardNum = new JTextField();
        this.cardNum.setBounds(250, 190, 200, 30);
        this.add(this.cardNum);
        JLabel pinNo = new JLabel("Pin No");
        pinNo.setFont(new Font("Osward", 1, 20));
        pinNo.setBounds(150, 250, 400, 40);
        this.add(pinNo);
        this.pinNum = new JPasswordField();
        this.pinNum.setBounds(250, 250, 200, 30);
        this.add(this.pinNum);
        this.setTitle("Automatic Teller Machine");
        this.setSize(600, 500);
        this.setLocation(300, 100);
        this.setVisible(true);
        this.login = new JButton("Login");
        this.login.setBounds(150, 300, 150, 30);
        this.login.setBackground(Color.BLACK);
        this.login.setForeground(Color.white);
        this.login.addActionListener(this);
        this.add(this.login);
        this.clear = new JButton("Cancel");
        this.clear.setBounds(350, 300, 150, 30);
        this.clear.setBackground(Color.BLACK);
        this.clear.setForeground(Color.white);
        this.clear.addActionListener(this);
        this.add(this.clear);


        this.signUp = new JButton("Sign Up");
        this.signUp.setBounds(200, 350, 300, 30);
        this.signUp.setBackground(Color.BLACK);
        this.signUp.setForeground(Color.white);
        this.signUp.addActionListener(this);
        this.add(this.signUp);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.clear) {
            this.pinNum.setText("");
            this.cardNum.setText("");
        } else if (ae.getSource() == this.login) {
            Conn conn = new Conn();
            String cardNo = cardNum.getText();
            String pinNo = pinNum.getText();
            String query = "select *  from login where cardNo = '" + cardNo + "'and pinNo = '" + pinNo + "'";

            try {
               ResultSet rs= conn.s.executeQuery(query);
               if (rs.next())
               {setVisible(false);
                   new Transactions(pinNo).setVisible(true);

               }else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                   }
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
           else if (ae.getSource() == this.signUp) {
                setVisible(false);
                new SignUpOne().setVisible(true);

            }

        }


    public static void main(String[] args) {
        new Login();
    }
}

