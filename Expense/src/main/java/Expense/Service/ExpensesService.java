package Expense.Service;

import Expense.Dao.ExpensesDao;
import Expense.Model.Expense;

import java.util.List;

public class ExpensesService {

    ExpensesDao expensesDao = new ExpensesDao();

    public void addExpense(Expense expense) {
       expensesDao.addExpense(expense);
    }

    public void updateExpense(Expense expense) {
        expensesDao.updateExpense(expense);
    }

    public void deleteExpenseId(int expenseId) {
        expensesDao.deleteCourseById(expenseId);
    }

    public List<Expense> findAll() {
        return expensesDao.findAll();
    }
}
