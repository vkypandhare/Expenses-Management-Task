package Expense.util;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Expense.Constant.ExpenseConstant.*;
import static jakarta.servlet.SessionTrackingMode.URL;

public class ConnectionUtil {

    @Getter
    public static Connection connection;
    static {
        try{
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);

        }catch (ClassNotFoundException e){
            System.out.println("Driver Class not found");
        } catch (SQLException e) {
            System.out.println("Invalid credential");
        }
    }
}
