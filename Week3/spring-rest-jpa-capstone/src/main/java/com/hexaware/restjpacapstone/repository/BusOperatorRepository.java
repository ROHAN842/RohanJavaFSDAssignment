package com.hexaware.restjpacapstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.restjpacapstone.entity.BusOperator;

@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Integer> {

	// Below one is example of the custom query
	
	@Query("SELECT b FROM BusOperator b WHERE b.operatorName LIKE 'A%'")

	List<BusOperator> getNameStartWithA(String operatorname);
	
	// now below one is one DML query example to delete by operator name so here will use @Modifying annotation here
	// in the repository/ DAo interface also will use @Transactional annotation in the Service Implementation class
	
	@Modifying
	@Query("delete from BusOperator b where b.operatorName = ?1")
	int deleteBusOperatorByName(String operatorname);
	
	
	

}
