package it.riccardofalzea.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.riccardofalzea.model.Contract;
import it.riccardofalzea.model.Customer;
import it.riccardofalzea.model.TypeContract;
import it.riccardofalzea.model.TypeCustomer;

public interface ContractRepository extends JpaRepository <Contract, Long> {
	Page <Optional<Contract>>  findByOrderByCustomerNameCustomer (Pageable page, String name);
	Page <Optional<Contract>> findByDateOfStart (Pageable page, LocalDate date);
	Page <Optional<Contract>> findByTypeContract (Pageable page, TypeContract typeContract);
	Page <Optional<Contract>> findByCustomerTypeCustomer (Pageable page, TypeCustomer typeCustomer);
	@Query("SELECT c.customer.contract FROM Contract c WHERE c.customer=:custom")
	Page<Optional<Contract>> findContract(Pageable page, Customer custom);
	
}
