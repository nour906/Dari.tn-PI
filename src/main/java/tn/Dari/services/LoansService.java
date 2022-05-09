package tn.Dari.services;

import java.util.List;

/*import org.springframework.mail.MailException;*/

import tn.Dari.entities.*;

public interface LoansService {

	List<LoansSimulationBank> getAllLoans();

	List<LoansSimulationBank> getAllLoansByNameBank(String namebank);

	LoansSimulationBank getLoansById(Long id);

	LoansSimulationBank deleteLoanById(Long id);

	void confirmLoan(Long idloan);

	void unConfirmLoan(Long idloan);

	LoansSimulationBank approcheLoan();

	LoansSimulationBank addLoan(String namebank, int years, int AdID, double salaire, Long iduser);


	LoansSimulationBank simulate(String nameBank, int nbrAnnee, long idad, double salaire);

	




}
