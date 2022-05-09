package tn.Dari.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banks")
@Entity
@Getter
@Setter
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbank")
	private long bankId ; 
	
	@Column(name = "Namebank")
	public String namebank;
	
	@Column(name = "DESCRIPTION")
	public String descbank;

	public String adressbank;

	public float margeInteretbank;

	public float taux;
	

	@OneToOne
	private Agent agent;
	
	

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getNamebank() {
		return namebank;
	}

	public void setNamebank(String namebank) {
		this.namebank = namebank;
	}

	public String getDescbank() {
		return descbank;
	}

	public void setDescbank(String descbank) {
		this.descbank = descbank;
	}

	public String getAdressbank() {
		return adressbank;
	}

	public void setAdressbank(String adressbank) {
		this.adressbank = adressbank;
	}

	public float getMargeInteretbank() {
		return margeInteretbank;
	}

	public void setMargeInteretbank(float margeInteretbank) {
		this.margeInteretbank = margeInteretbank;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}


}
