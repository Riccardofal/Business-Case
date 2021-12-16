package it.riccardofalzea.controller;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.riccardofalzea.model.Contract;
import it.riccardofalzea.model.Customer;
import it.riccardofalzea.model.TypeContract;
import it.riccardofalzea.model.TypeCustomer;
import it.riccardofalzea.service.ContractService;
import it.riccardofalzea.service.CustomerService;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	ContractService contractService;
	@Autowired
	CustomerService customerService;
	
	@PostMapping ("/addcontract")
	public String addContract (@RequestBody Contract contract) {
		contractService.insertNewContract(contract);
		return "contract saved";
	}
	
	@GetMapping ("/deletecontract")
	public String deleteContract (@RequestParam Long id) {
		contractService.deleteContract(id);
		return "contract deleted";
	}
	
	@PostMapping ("/addcustomer")
	public String addCustomer (@RequestBody Customer customer) {
		customerService.insertNewCustomer(customer);
		return "customer saved";
	}
	
	@GetMapping ("/deletecustomer")
	public String deleteCustomer (@RequestParam Long id) {
		customerService.deleteCustomer(id);
		return "customer deleted";
		
	}
	
	@GetMapping("/customersname")
	public ResponseEntity<?> findCustomersName (Pageable pageable, @RequestParam String name){
		Page<Optional<Contract>> findAll= contractService.findByOrderByCustomerNameCustome(pageable,name);
		if (findAll.hasContent()) {
            return new ResponseEntity<> (findAll, HttpStatus.OK);
		}else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);			

	}
	
	@GetMapping("/dateofstart")
	public ResponseEntity<?> findByDateOfStart (Pageable pageable, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
		Page<Optional<Contract>> findAll= contractService.findByDateOfStart(pageable,data);
		if (findAll.hasContent()) {
            return new ResponseEntity<> (findAll, HttpStatus.OK);
		}else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);			
}
	
	@PostMapping ("/typeofcontract")
	public ResponseEntity<?> findByTypeOfContract (Pageable pageable, @RequestBody TypeContract typeContract ){
		Page<Optional<Contract>> findAll= contractService.findByTypeContract(pageable,typeContract);
		if (findAll.hasContent()) {
            return new ResponseEntity<> (findAll, HttpStatus.OK);
		}else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping ("/typeofuser")
	public ResponseEntity<?> findByTypeOfUser (Pageable pageable, @RequestBody TypeCustomer typeCostumer){
		Page<Optional<Contract>> findAll= contractService.findByCustomerTypeCustomer(pageable,typeCostumer);
		if (findAll.hasContent()) {
            return new ResponseEntity<> (findAll, HttpStatus.OK);
		}else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping ("/contractsofoneuser")
	public ResponseEntity<?> findContract (Pageable pageable, @RequestBody Customer custom){
		Page<Optional<Contract>> findAll= contractService.findContract(pageable,custom);
		if (findAll.hasContent()) {
            return new ResponseEntity<> (findAll, HttpStatus.OK);
		}else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
	}
	
	
	
	

}
