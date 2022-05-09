package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.Bank;
import tn.Dari.entities.Subscription;


@Repository
public interface BankRepository  extends CrudRepository<Bank, Long> {

	//Bank getBankByNamebank (Bank bank) ;
	/*
    @Query(value = "SELECT * FROM t_banks WHERE namebank=?1",nativeQuery=true)
	Bank getBankByName(String Namebank);

    @Query("SELECT * FROM Bank WHERE idbank=?1") 
	Bank getBankById(Long Idbank);
	
    
    @Query(value = "SELECT * FROM t_banks",nativeQuery=true) 
	List<Bank> getAllBanks();
*/	
	
	
    Bank findByNamebank(String namebank);

}
