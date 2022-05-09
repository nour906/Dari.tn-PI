package tn.Dari.repository;

import java.util.List;
import tn.Dari.entities.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository  extends CrudRepository <LoansSimulationBank, Long> {

	@Query(value="SELECT * FROM loans l join banks b on l.bank_idbank=b.idbank WHERE b.namebank=?1",nativeQuery=true)
	List<LoansSimulationBank> getAllLoansByNameBank(String Namebank);


}