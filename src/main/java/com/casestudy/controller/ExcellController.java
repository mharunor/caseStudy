package com.casestudy.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.casestudy.entity.Loan;
import com.casestudy.message.ResponseMessage;
import com.casestudy.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;


@CrossOrigin
@RestController
@RequestMapping("/api/excel")
public class ExcellController {
	
	
	@Autowired
	  ExcelService fileService;

	 
	  
	  @RequestMapping(value = "/import-excel", method = RequestMethod.POST)
	    public ResponseEntity<List<Loan>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException, ParseException {
	        HttpStatus status = HttpStatus.OK;
	        List<Loan> loanList = new ArrayList<>();

	        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
	        XSSFSheet worksheet = workbook.getSheetAt(0);
	        DataFormatter dataFormatter = new DataFormatter();
	      

	        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
	            if (index > 0) {
	                  Loan loan = new Loan();

	                  XSSFRow row = worksheet.getRow(index);
	                  if(row.getCell(0)!=null)
	                  loan.setLoanNo((long) row.getCell(0).getNumericCellValue());
	                  if(row.getCell(1)!=null)
	                  loan.setBorrowerName(row.getCell(1).getStringCellValue());
	            	  
	            	  //loan.setDob(new SimpleDateFormat("MM/dd/yyyy").parse(dataFormatter.formatCellValue( row.getCell(2))));
	                  if(row.getCell(2)!=null)
	                  loan.setDob(dataFormatter.formatCellValue( row.getCell(2)));
	            	  
	                  if(row.getCell(3)!=null)
	                  loan.setPropertyAddress(row.getCell(3).getStringCellValue());
	            	  
	                  if(row.getCell(4)!=null)
	                  loan.setCost(row.getCell(4).getNumericCellValue());
	            	  
	                  
	                  if(row.getPhysicalNumberOfCells()>5 && row.getCell(5)!=null)
	            	  loan.setFloodRisk(row.getCell(5).getStringCellValue());
	                  //fileService.save(loan);
	                loanList.add(loan);
	            }
	            
	            
	        }
	        
	        fileService.saveAll(loanList);
	        
	        

	        return new ResponseEntity<>(fileService.getAllLoan(),status);
	    }
	  
	  
	  

	 
}



    
