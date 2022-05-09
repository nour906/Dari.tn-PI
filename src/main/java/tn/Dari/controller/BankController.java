package tn.Dari.controller;



import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.repository.*;
import tn.Dari.entities.*;
import tn.Dari.services.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/App/Bank")
public class BankController {

	@Autowired
	BankService bankservice;
	@Autowired
	AgentRepository Agentrepo;
	
	@Autowired
	UserServiceImpl UsersService;
	@Autowired
	UserController UsersController;
	
	@Autowired
	private BankService bankService ; 
	
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@PostMapping("/addBank")
	public Bank AddB (@RequestBody Bank bank) {
	bankService.addbank(bank);
	System.out.println(bank);
	return bank;
	}
	/*{
	    "bankId": 3 ,
    "namebank": "azer",
    "Descbank": 0,
    "Adressbank": "DAREK",
    "MargeInteretbank": 12.2 ,
    "taux": 12.0
    }
	 */
	
	@PutMapping("/updateBank/{bankId}")
	@ResponseBody
	public Bank updateBank (@RequestBody Bank bank,
			@PathVariable("bankId") Long bankId) {
	return bankService.updateBank(bankId,bank);
	}
	
	@DeleteMapping("/deleteBank/{bankId}")
	public String deleteBankByID(@PathVariable("bankId") Long bankId) {
		Bank bank = bankService.getBankById(bankId);
		/*if(Objects.isNull(bank.getAgent()) )
		{
			bankService.deleteBankByID(bankId);
		}else {	
		
		bankService.deleteAgentByID(bank.getAgent().getId()); */
		bankService.deleteBankByID(bankId);
		
		
		return "bank "+ bank.namebank +" has been deleted";
	}
	
	@PostMapping("/addagent/{bankId}")
	public Agent Addagent (@RequestBody Agent agent,@PathVariable("bankId") Long bankId) {
	bankService.addagent(agent,bankId);
	return agent;
	}
	/*
	"Firstname":"Youssef",
    "Lastname":"Mechichi",
    "datenaissance":"2000-04-17",
    "Email":"youssef.mechichi@esprit.tn",
    "Password":"181JMT2801",
    "Phone":"52350418",
    "Adress":"14 Rue Salambo"
	*/
	
	@DeleteMapping("/deleteagent/{agentId}")
	public String deleteagentByID(@PathVariable("agentId") Long agentId) {
		Agentrepo.findById(agentId).get().getBank().setAgent(null);
		bankService.deleteAgentByID(agentId);
		return "agent "+ agentId +" has been deleted";
	}
	
	
	@GetMapping("/getBankById/{id}")
	@ResponseBody
	public Bank getBankById(@PathVariable("id") Long id) {
		return bankService.getBankById(id);
	}
	
	@GetMapping("/getallBanks")
	@ResponseBody
	public List<Bank> getAllBanks() {
		
	 	List<Bank> banks = bankService.getAllBank();
	 	return banks;
	}
	
	@GetMapping("/getallagents")
	@ResponseBody
	public List<Agent> getAllagents() {
		
	 	List<Agent> agent = bankService.getAllagents();
	 	return agent;
	}
	
	@GetMapping("/getBankname/{namebank}")
	@ResponseBody
	public Bank findbankname (@PathVariable("namebank") String namebank)
	{
		return bankService.findnb(namebank);
	}
	
	
 	@GetMapping("/getagent/{nameBank}")
    @ResponseBody
    public Agent getag (@PathVariable  String nameBank)
    {
    	Agent agent=bankService.getagentbynamebank(nameBank);
    	return agent;
	
}
	
}
