package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,exit,cardless,balanceEnquiry,withdraw,statement;
    String pinnumber;
    Transactions(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("Transactions");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 600);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(170, 240, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150, 280, 100, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(260, 280, 100, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        statement = new JButton("Statement");
        statement.setBounds(260, 330, 100, 30);
        statement.addActionListener(this);
        image.add(statement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(260, 280, 100, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);


        cardless = new JButton("Cardless");
        cardless.setBounds(150, 330, 100, 30);
        cardless.addActionListener(this);
        image.add(cardless);

        exit = new JButton("Exit");
        exit.setBounds(210, 370, 100, 30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(650, 650);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == exit) {
                System.exit(0);
            }
            else if(ae.getSource()==deposit)
            {
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }
            else if(ae.getSource()==cardless)
            {
                //new Deposit(pinnumber).setVisible(true);
                setVisible(false);
            } else if(ae.getSource()==withdraw)
            {
                new Withdrawal(pinnumber).setVisible(true);
                setVisible(false);
            }else if(ae.getSource()==statement)
            {
                new MiniStatement(pinnumber).setVisible(true);
                setVisible(false);
            }
        }


        public static void main(String[] args){
            new Transactions("");
        }





}
