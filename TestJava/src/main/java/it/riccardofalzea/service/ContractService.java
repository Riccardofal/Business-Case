package it.riccardofalzea.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.riccardofalzea.model.Contract;
import it.riccardofalzea.model.Customer;
import it.riccardofalzea.model.TypeContract;
import it.riccardofalzea.model.TypeCustomer;
import it.riccardofalzea.repository.ContractRepository;

@Service
public class ContractService {
	@Autowired
	ContractRepository contractRepository;

	public void insertNewContract(Contract contract) {
		contractRepository.save(contract);

	}

	public void deleteContract(Long id) {
		contractRepository.deleteById(id);
	}

	public Page<Optional<Contract>> findByOrderByCustomerNameCustome(Pageable page, String name) {
		return contractRepository.findByOrderByCustomerNameCustomer(page, name);
	}

	public Page<Optional<Contract>> findByDateOfStart(Pageable page, LocalDate date) {
		return contractRepository.findByDateOfStart(page, date);
	}

	public Page<Optional<Contract>> findByTypeContract(Pageable page, TypeContract typeContract) {
		return contractRepository.findByTypeContract(page, typeContract);
	}

	public Page<Optional<Contract>> findByCustomerTypeCustomer(Pageable page, TypeCustomer typeCustomer) {
		return contractRepository.findByCustomerTypeCustomer(page, typeCustomer);
	}

	public Page<Optional<Contract>> findContract(Pageable page, Customer custom) {
		return contractRepository.findContract(page, custom);
	}

}
