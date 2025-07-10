package com.jasmitha.expensetracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import com.jasmitha.expensetracker.model.Expense;
import com.jasmitha.expensetracker.repository.ExpenseRepository;

@SpringBootApplication
@EntityScan("com.jasmitha.expensetracker.model")
public class ExpensetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ExpenseRepository repo) {
		return args -> {
			repo.save(new Expense("Test Insert", 1.0, "Debug", LocalDate.now()));
		};
	}
}