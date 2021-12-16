package it.riccardofalzea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.riccardofalzea.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
