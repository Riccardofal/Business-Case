package it.riccardofalzea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardofalzea.model.Customer;
import it.riccardofalzea.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public void insertNewCustomer(Customer customer) {
		customerRepository.save(customer);

	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
