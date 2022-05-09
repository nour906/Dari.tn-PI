package tn.Dari.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loans")
public class LoansSimulationBank {

	public long getIdLoan() {
		return IdLoan;
	}

	public void setIdLoan(long idLoan) {
		IdLoan = idLoan;
	}

	public double getTaux() {
		return Taux;
	}

	public void setTaux(double taux) {
		Taux = taux;
	}

	public double getMensuel() {
		return Mensuel;
	}

	public void setMensuel(double mensuel) {
		Mensuel = mensuel;
	}

	public double getCapaciteRembouresement() {
		return CapaciteRembouresement;
	}

	public void setCapaciteRembouresement(double capaciteRembouresement) {
		CapaciteRembouresement = capaciteRembouresement;
	}

	public double getInteret() {
		return Interet;
	}

	public void setInteret(double interet) {
		Interet = interet;
	}

	public double getInteretall() {
		return Interetall;
	}

	public void setInteretall(double interetall) {
		Interetall = interetall;
	}

	public double getMensualite() {
		return Mensualite;
	}

	public void setMensualite(double mensualite) {
		Mensualite = mensualite;
	}

	public double getPrincipale() {
		return Principale;
	}

	public void setPrincipale(double principale) {
		Principale = principale;
	}

	public double getMontantRemb() {
		return MontantRemb;
	}

	public void setMontantRemb(double montantRemb) {
		MontantRemb = montantRemb;
	}

	public double getPrixprod() {
		return Prixprod;
	}

	public void setPrixprod(double prixprod) {
		Prixprod = prixprod;
	}

	public double getSalaire() {
		return Salaire;
	}

	public void setSalaire(double salaire) {
		Salaire = salaire;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getStartedDate() {
		return StartedDate;
	}

	public void setStartedDate(String startedDate) {
		StartedDate = startedDate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDloan")
	public long IdLoan;
	
	public double Taux;
	
	public double Mensuel;
	
	public double CapaciteRembouresement;
	
	public double Interet;
	
	public double Interetall;
	
	public double Mensualite;
	
	public double Principale;
	
	public double MontantRemb;
	
	public double Prixprod;
	
	public double Salaire;
	
	public String Status;
	
	public String StartedDate;
	
	@ManyToOne
	Bank bank;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Agent agent;
}
