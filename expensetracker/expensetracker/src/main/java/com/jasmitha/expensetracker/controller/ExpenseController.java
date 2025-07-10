package com.jasmitha.expensetracker.controller;
import com.jasmitha.expensetracker.model.Expense;
import com.jasmitha.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return service.getExpensesByCategory(category);
    }

    @GetMapping("/between")
    public List<Expense> getBetween(@RequestParam LocalDate start,
                                    @RequestParam LocalDate end) {
        return service.getExpensesBetweenDates(start, end);
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        return Map.of("totalExpense", service.getTotalExpense());
    }
}