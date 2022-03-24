package com.harman.dataproj;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Data {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String employee_code, employee_name, employee_designation, employee_salary, employee_mobileno;
            System.out.println("Enter the code: ");
            employee_code = input.next();
            System.out.println("Enter the name: ");
            employee_name = input.next();
            System.out.println("Enter the designation: ");
            employee_designation = input.next();
            System.out.println("Enter the salary: ");
            employee_salary = input.next();
            System.out.println("Enter the mobile no: ");
            employee_mobileno = input.next();
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
            Statement stat = c.createStatement();
            stat.executeUpdate("INSERT INTO `employee`(`employee_code`, `employee_name`, `employee_designation`, `employee_salary`, `employee_mobileno`) VALUES("+employee_code+",'"+employee_name+"','"+employee_designation+"',"+employee_salary+","+employee_mobileno+")");
            System.out.println("inserted sucessfully");
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
