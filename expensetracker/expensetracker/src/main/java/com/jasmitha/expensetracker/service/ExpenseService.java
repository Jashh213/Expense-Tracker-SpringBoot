package com.jasmitha.expensetracker.service;

import com.jasmitha.expensetracker.model.Expense;
import com.jasmitha.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository repository;

    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Expense> getExpensesBetweenDates(LocalDate start, LocalDate end) {
        return repository.findByDateBetween(start, end);
    }

    public double getTotalExpense() {
        return repository.findAll().stream()
                         .mapToDouble(Expense::getAmount)
                         .sum();
    }
}