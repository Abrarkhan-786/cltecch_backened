package com.cltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cltech.model.AddressModel;


@Repository
public interface AddressModelRepository extends JpaRepository<AddressModel, Long> {
	
	

}
