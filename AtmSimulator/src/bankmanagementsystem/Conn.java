package bankmanagementsystem;

import java.sql.*;

public class Conn {



    Connection c;
    Statement s;

    public Conn() {
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsyste","root","placement");
            s=c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }

    

    }

}
