//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
           // class.forName(com.mysql.cj.jdbc.Driver);
             c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "123456");
             s=c.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

