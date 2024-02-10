package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.ResultSet;




public class MiniStatement extends JFrame{

    MiniStatement(String pinnumber){
setTitle("Mini Statement");
setLayout(null);
JLabel mini=new JLabel();
add(mini);

JLabel bank=new JLabel("Batlokwa Bank");
bank.setBounds(150,20,100,20);
add(bank);

JLabel card=new JLabel();
card.setBounds(20,80,300,20);
add(card);

setSize(400,600);
setLocation(20,20);
getContentPane().setBackground(Color.WHITE);
setVisible(true);

try{
Conn conn=new Conn();
ResultSet rs=conn.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
while (rs.next())
{
  card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
}

}catch(Exception e)
{
    System.out.println(e);
}
try
{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
  while(rs.next())
  {
      mini.setText(mini.getText()+rs.getString("date"));
  }
}catch(Exception e)
{
    System.out.println(e);
}




    }
    public static void main(String[] args) {
        new MiniStatement("");
    }


}
