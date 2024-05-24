package Expense.Dao;

import Expense.*;
import Expense.Model.Expense;
import Expense.util.ConnectionUtil;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ExpensesDao {

    @SneakyThrows

    public void addExpense(Expense expense)  {
        Connection connection = ConnectionUtil.getConnection();
        String sqlQuery = "insert into Expenses.expense(Expenses_id, Expenses_name, Add_Expenses, Expenses_Description, Start_date, End_date) values(?,?,?,?,?.?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1,expense.getExpenses_Id());
        preparedStatement.setString(2, expense.getExpenses_Name());
        preparedStatement.setString(3,expense.getAdd_Expenses());
        preparedStatement.setString(4,expense.getExpenses_Description());
        preparedStatement.setDate(5, (Date) expense.getStart_Date());
        preparedStatement.setDate(6, (Date) expense.getEnd_Date());
        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("Expenses Added");
    }

    @SneakyThrows
    public void updateExpense(Expense expense) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "update expense set Expenses_name=?, Add_Expenses=?, Expenses_Description=?,Start_date=?, End_date=? where Expenses_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,expense.getExpenses_Name());
        preparedStatement.setString(2,expense.getAdd_Expenses());
        preparedStatement.setString(3,expense.getExpenses_Description());
        preparedStatement.setDate(4, (Date) expense.getStart_Date());
        preparedStatement.setDate(5, (Date) expense.getEnd_Date());
        preparedStatement.setInt(1,expense.getExpenses_Id());
        preparedStatement.executeUpdate();
        System.out.println("Expense updated");
        connection.close();
    }

    @SneakyThrows
    public void deleteCourseById(int expenseId) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "delete from expense where Expenses_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, expenseId);
        preparedStatement.executeUpdate();
        System.out.println("Expense deleted successfully");
        connection.close();
    }


    @SneakyThrows
    public List<Expense> findAll() {
        List<Expense> expenseList = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        String query = "select from expense;";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Expense expense = Expense.builder()
                    .expenses_Id(resultSet.getInt("Expenses_id"))
                    .expenses_Name(resultSet.getString("Expenses_name"))
                    .add_Expenses(resultSet.getString("Add_Expenses"))
                    .expenses_Description(resultSet.getString("Expenses_Description"))
                    .start_Date(resultSet.getDate("Start_date"))
                    .end_Date(resultSet.getDate("Start_date"))
                    .build();
            expenseList.add(expense);
        }
        connection.close();
        return expenseList;
    }
}



