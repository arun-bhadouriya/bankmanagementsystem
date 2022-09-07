package bms;

import java.sql.*;
public class Conn {
    Statement s;
    Connection con;
    public Conn(){
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql:///bankmangement","root","arun@12345"
            );
            s = con.createStatement();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String[] args) {
//        Conn c = new Conn();
    }
}
