package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.*;


public interface BankService  {

	void addbank(Bank bank);
	
	Bank updateBank (Long bankID,Bank bank);
	
	void deleteBankByID(Long bankID);
		
	Bank getBankById(Long id);
	
	List<Bank> getAllBank();
	
	Agent getagentbynamebank(String namebank);

	void addagent(Agent agent, Long idbank);

	List<Agent> getAllagents();

	void deleteAgentByID(Long agentID);
	
	public Bank findnb(String namebank);

}
