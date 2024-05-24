package Expense.Controller;

import Expense.Model.Expense;
import Expense.Service.ExpensesService;

import java.util.List;

public class ExpensesController {

    ExpensesService expenseService = new ExpensesService();
    public void addExpense(Expense expense) {
        expenseService.addExpense(expense);
    }

    public void updateExpense(Expense expense){
        expenseService.updateExpense(expense);
    }

    public void deleteExpenseById(int expenseId) {
        expenseService.deleteExpenseId(expenseId);
    }

    public List<Expense> findAll() {
        return expenseService.findAll();
    }
}
