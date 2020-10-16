package com.casestudy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casestudy.entity.Loan;
import com.casestudy.repository.LoanRepository;

@Transactional
@Service
public class ExcelService {
	
	@Autowired
	 LoanRepository repository;

	 

	  public List<Loan> getAllLoan() {
	    return repository.findAll();
	  }
	  
	 
	  public void saveAll(List<Loan> loans) {
		  
		  repository.saveAll(loans); 
		  repository.flush();
		  //repository.saveAndFlush(loans.get(0));
	  }
	  
	  public void save(Loan loan) {
		  repository.saveAndFlush(loan);
	  }

}
