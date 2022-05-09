package tn.Dari.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.entities.*;
import tn.Dari.repository.*;

@Service
public class LoansServiceImpl implements LoansService {

	
	@Autowired
	LoansRepository loanRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	AnnouncementRepository adRepository;
	

	
	@Autowired
	UserRepository userRepository;

	@Autowired
	BankService bankservice;
	
	
	@Override
	public List<LoansSimulationBank> getAllLoans() {
		return (List<LoansSimulationBank>) loanRepository.findAll();
	}
	
	
	@Override
	public LoansSimulationBank getLoansById(Long id) {

		return loanRepository.findById(id).get();
	}
	@Override
	public LoansSimulationBank addLoan(String namebank,int years ,int AdID,double salaire,Long iduser)
	{
		Agent agent=bankservice.getagentbynamebank(namebank);
		User user ;
		LoansSimulationBank simulation= simulate(namebank, years, AdID, salaire);
		user=userRepository.findById(iduser).get();
		//agent=bankservice.getagentbynamebank(namebank);
		simulation.setUser(user);
		simulation.setAgent(agent);
		simulation.setStatus("IN_PROGRESS");
		

		LoansSimulationBank loan=loanRepository.save(simulation);

		return (simulation);
	}
	
	

	public LoansSimulationBank deleteLoanById(Long id) {
		LoansSimulationBank l=loanRepository.findById(id).get();
		loanRepository.delete(l);
		return l;
	}	
		
	@Override
	public void confirmLoan(Long idloan) {
		
		LoansSimulationBank simulation=loanRepository.findById(idloan).get();
		simulation.setStatus("CONFIRMED");
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		simulation.setStartedDate(formatter.format(date));
		loanRepository.save(simulation);
		
	}
	
	@Override
	public void unConfirmLoan(Long idloan) {
		
		LoansSimulationBank simulation=loanRepository.findById(idloan).get();
		simulation.setStatus("DENIED");
		simulation.setStartedDate(null);

		loanRepository.save(simulation);
		
	}	
	@Override
	public LoansSimulationBank approcheLoan() {
		
		return null;}



@Override
public LoansSimulationBank simulate(String nameBank, int nbrAnnee, long idad, double salaire) {
	
	LoansSimulationBank simulation= new LoansSimulationBank();
	

	Bank bank=bankRepository.findByNamebank(nameBank);
	
	Announcement ad=adRepository.findByidan(idad);
	System.out.println("name"+nameBank);
	System.out.println("years"+ nbrAnnee);
	System.out.println("id"+ idad);
	System.out.println("price"+ ad.getPrice());
	System.out.println("sal"+ salaire);
	//User user=userRepository.getClientByCin(cin);
//	simulation.setUser(user);	
	
	simulation.setBank(bank);
	
	simulation.setTaux(calculTaux(bank));
	
	simulation.setMensuel(calculTauxMensuel(bank));
	
	simulation.setCapaciteRembouresement(calculCapaciteDeRemboursement(salaire));
	
	simulation.setMensualite(calculMensualite(ad, bank, nbrAnnee));
	
	simulation.setInteret(calculInteret(ad, bank));
	
	simulation.setInteretall(calculInteretTotale(ad,bank,nbrAnnee));
	
	simulation.setPrincipale(calculPrincipale(ad, bank, nbrAnnee));
	
	simulation.setMontantRemb(calculMontantRembourse(ad, bank, nbrAnnee));
	
	simulation.setPrixprod(ad.getPrice());
	simulation.setSalaire(salaire);
	
	return (simulation);
}



public double calculTaux(Bank bank)
{
	double ctaux = ( bank.getTaux() + bank.getMargeInteretbank() /100 ) ;
	
	return ctaux;
}

public double calculTauxMensuel(Bank bank)
{
	return (calculTaux(bank)/12);

}

public double calculNbrEcheance (int years) 
{
	return (years*12);	
}

public double calculCapaciteDeRemboursement(double salaire)
{
	return (salaire*0.4);
}

public double calculInteret(Announcement Ads , Bank bank)
{
double price=Ads.getPrice();
double tauxMensuel=calculTauxMensuel(bank);
return (price*tauxMensuel);
}

public double calculMensualite(Announcement Ads,Bank bank,int years) 
{
	double tauxMensuel=calculTauxMensuel(bank);
	System.out.println("taux  "+ tauxMensuel);
	double interet = Ads.getPrice() * tauxMensuel;
	System.out.println("interet"+ interet);
	double nbrecheance=calculNbrEcheance(years)*(-1);
	System.out.println("nbr cheance "+ nbrecheance);
	double power=Math.pow(1+tauxMensuel, nbrecheance);
	System.out.println("power "+ power);
	double q= 1 - power;

		return (interet/q);

}

public double calculPrincipale(Announcement Ads, Bank bank ,int years)
{
	double mensualite = calculMensualite(Ads,bank,years);
	double interet = calculInteret(Ads, bank);
	
	return (mensualite-interet);
}

public double calculMontantRembourse(Announcement ads , Bank bank , int years)
{
	return calculNbrEcheance(years)*calculMensualite(ads, bank, years);
}

public double calculInteretTotale(Announcement ads ,Bank bank, int years)
{
	return (calculMontantRembourse(ads, bank, years)-ads.getPrice());
}


@Override
public List<LoansSimulationBank> getAllLoansByNameBank(String namebank) {
	
	return loanRepository.getAllLoansByNameBank(namebank);
}



}
