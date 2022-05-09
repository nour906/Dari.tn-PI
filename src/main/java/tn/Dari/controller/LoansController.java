package tn.Dari.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.annotate.JsonIgnore;
import tn.Dari.entities.*;
import tn.Dari.repository.*;
import tn.Dari.services.BankService;
import tn.Dari.services.LoansService;
import tn.Dari.services.MailService;
import tn.Dari.services.PdfService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/App/Loan")
public class LoansController {
	
	
	@Autowired
	private PdfService pdfservice;
	
	@Autowired
	BankService bankservice;
	
	@Autowired
	LoansService loanservice;
	
	@Autowired
	MailService mailservice;
	
	@Autowired
	AgentRepository agrepository;
	
	@Autowired
	LoansRepository loanrepository;
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@PostMapping("/Simulate/{idad}/{nameBank}/{years}/{salaire}")
	@ResponseBody
	public LoansSimulationBank Simulate(@PathVariable long idad,
										@PathVariable String nameBank,
										@PathVariable int years,
										@PathVariable double salaire)
	{
		LoansSimulationBank result= loanservice.simulate(nameBank, years, idad, salaire);
		return result;	
	}
	
	@JsonIgnore
	@GetMapping("/getagent/{nameBank}")
    @ResponseBody
    public Agent getagent (@PathVariable  String nameBank)
    {
    	
    	return bankservice.getagentbynamebank(nameBank);
    }
	//add simulation
	@PostMapping("/addloan/{idad}/{iduser}/{nameBank}/{years}/{salaire}")
	@ResponseBody
	public String addSimulation(@PathVariable int idad,
										@PathVariable Long iduser,
										@PathVariable String nameBank,
										@PathVariable int years,
										@PathVariable double salaire) 
	{
		
		loanservice.addLoan(nameBank, years, idad, salaire, iduser);
		return ("loan simulation added");
		
	}
	
	
	@GetMapping("/getAllloans")
    @ResponseBody
	public List<LoansSimulationBank> getAllSimulations()
	{	
		return loanservice.getAllLoans();
	}
	
	//get all simulations by bank 
	@GetMapping("/getAllloansBynameBank/{nameBank}")
    @ResponseBody
	public List<LoansSimulationBank> getAllSimulationsByNameBank(@PathVariable("nameBank") String nameBank ) {
		System.out.println(nameBank);
		return loanservice.getAllLoansByNameBank(nameBank);
	}
	
	// delete simulation by id
	@DeleteMapping("/deleteById/{id}")
	@ResponseBody 
	public LoansSimulationBank deleteSimulationById(@PathVariable("id") Long id )
	{
		System.out.println(id);
		return loanservice.deleteLoanById(id);
			
	}
	
	// confirm simulation by id
	@PutMapping("/confirm/{id}")
	@ResponseBody 
	public void confirmSimulation(@PathVariable("id") Long id ){
		loanservice.confirmLoan(id);
		}
	
	// Unconfirm simulation by id
	@PutMapping("/unconfirm/{id}")
	@ResponseBody 
	public void unconfirmSimulation(@PathVariable("id") Long id ){
		loanservice.unConfirmLoan(id);
		}
	
	@PostMapping("/pdf/{idloan}")
	@ResponseBody
	public String pdf(@PathVariable long idloan) {
		
		 pdfservice.toPDF(idloan);
		 return "pdf generated";
	}
	
	@PostMapping("/mail/{idloan}")
	@ResponseBody
	public String emailwithpddf(@PathVariable long idloan) throws MailException, MessagingException {
		Agent agent =loanservice.getLoansById(idloan).getAgent();
		User user =loanservice.getLoansById(idloan).getUser();
		 mailservice.sendWithAttachment(user, agent, pdfservice.toPDF(idloan));
		 return "pdf generated";
	}

}
