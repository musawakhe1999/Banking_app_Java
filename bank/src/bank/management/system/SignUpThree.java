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
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class SignUpThree extends JFrame implements ActionListener{

    JCheckBox  checkbx,mobileBanking,eStatement,emailAlerts,internetBanking,chequeBook,atmCard;
    JRadioButton savingAcc,currentAcc,fixedDepositAccount,recurringDepositAccount;
    JTextField pinNoTextField,cardNoTextField;
    JButton submit,cancel;

    String formno;
    SignUpThree(String formno) {
        setTitle("Sign Up 3");
        this.formno=formno;
        this.setLayout((LayoutManager)null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/star.png"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, 1);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(30, 10, 100, 100);
        this.add(label);

        JLabel heading2 = new JLabel("Page 3: Account Details");
        heading2.setFont(new Font("Osward", 1, 20));
        heading2.setBounds(200, 40, 300, 30);
        this.add(heading2);

        JLabel title1 = new JLabel("Account Type:");
        title1.setFont(new Font("Osward", 1, 16));
        title1.setBounds(100, 130, 300, 30);
        this.add(title1);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setBounds(100, 170, 120, 30);
        this.add(savingAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setBounds(100, 200, 120, 30);
        this.add(currentAcc);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBounds(300, 170, 200, 30);
        this.add(fixedDepositAccount);

         recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setBounds(300, 200, 200, 30);
        this.add(recurringDepositAccount);

        JLabel title2 = new JLabel("Services Required:");
        title2.setFont(new Font("Osward", 1, 16));
        title2.setBounds(100, 250, 300, 30);
        this.add(title2);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(100, 300, 200, 30);
        this.add(atmCard);

       mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(100, 330, 200, 30);
        this.add(mobileBanking);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(100, 360, 200, 30);
        this.add(chequeBook);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(300, 300, 200, 30);
        this.add(internetBanking);

        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setBounds(300, 330, 200, 30);
        this.add(emailAlerts);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBounds(300, 360, 200, 30);
        this.add(eStatement);

        JLabel title3 = new JLabel("Card Number:");
        title3.setFont(new Font("Osward", 1, 14));
        title3.setBounds(100, 420, 200, 30);
        this.add(title3);

         cardNoTextField = new JTextField();
        cardNoTextField.setBounds(300, 420, 250, 30);
        this.add(cardNoTextField);

        JLabel title4 = new JLabel("Pin Number:");
        title4.setFont(new Font("Osward", 1, 14));
        title4.setBounds(100, 460, 300, 30);
        this.add(title4);

         pinNoTextField = new JTextField();
        pinNoTextField.setBounds(300, 460, 250, 30);
        this.add(pinNoTextField);

        checkbx = new JCheckBox();
        checkbx.setBounds(200, 500, 20, 30);
        this.add(checkbx);

        JLabel textLbl = new JLabel("I accept terms and conditions");
        textLbl.setBounds(220, 500, 600, 30);
        this.add(textLbl);

         submit = new JButton("Submit");
        submit.setBounds(200, 540, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        this.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(340, 540, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        this.add(cancel);

        this.setSize(700, 700);
        this.setLocation(300, 70);
        this.setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit)
          {
              String accountType=null;
             // savingAcc,currentAcc,fixedDepositAccount,recurringDepositAccount;
              if(savingAcc.isSelected())
              {
                  accountType="Saving Account";

              } else if(currentAcc.isSelected())
              {
                  accountType="Current Account";

              }else if(fixedDepositAccount.isSelected())
              {
                  accountType="Fixed Deposit Account";
              }else if(recurringDepositAccount.isSelected())
              {
                  accountType="Recurring Deposit Account";

              }
              Random random=new Random();
              String cardNo=""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
              String pinNo=""+Math.abs((random.nextLong()% 9000L)+1000L);

          String facility="";

          if(mobileBanking.isSelected())
          {
              facility=facility+"Mobile Banking";
          }else if(eStatement.isSelected())
          {
              facility=facility+"E-Statement";
          }else if(emailAlerts.isSelected())
          {
              facility=facility+"Email Alerts";
          }else if(internetBanking.isSelected())
          {
              facility=facility+"Internet Banking";
          }else if(chequeBook.isSelected())
          {
              facility=facility+"Cheque Book";
          }else if(atmCard.isSelected())
          {
              facility=facility+"ATM Card";
          }
try {
if (accountType.equals(""))
{
    JOptionPane.showMessageDialog(null,"Account type is required");
}else {
    Conn conn=new Conn();
    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardNo+"','"+pinNo+"','"+facility+"')";
    String query2="insert into login values('"+formno+"','"+cardNo+"','"+pinNo+"')";

    conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);
    JOptionPane.showMessageDialog(null,"Card Number: "+cardNo+"\n Pin: "+pinNo);
    setVisible(false);
    new Deposit(pinNo).setVisible(true);
}


}
catch (Exception e)
{
    System.out.println(e);
}

          }else if (ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
