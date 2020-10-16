package com.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	public List<Loan>findAll();
	public void save(List<Loan> loans);

}
