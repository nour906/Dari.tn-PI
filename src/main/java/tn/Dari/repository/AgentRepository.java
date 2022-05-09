package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.Dari.entities.Agent;
import tn.Dari.entities.Subscription;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository  extends CrudRepository<Agent,Long>  {

	//@Query("SELECT * FROM dari.banks b join dari.Agents a on a.idag=b.agentb_idag WHERE b.namebank= :Bankname")
	//Agent getAgentnamebank(@Param("Bankname")String namebank);
}
