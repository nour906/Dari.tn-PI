package tn.Dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Agents")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idag")
	private long Id;
	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFirstname() {
		return Firstname;
	}


	public void setFirstname(String firstname) {
		Firstname = firstname;
	}


	public String getLastname() {
		return Lastname;
	}


	public void setLastname(String lastname) {
		Lastname = lastname;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}


	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public int getPhone() {
		return Phone;
	}


	public void setPhone(int phone) {
		Phone = phone;
	}


	public String getAdress() {
		return Adress;
	}


	public void setAdress(String adress) {
		Adress = adress;
	}


	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	private String Firstname;
	private String Lastname;
	private Date datenaissance;
	private String Email;
	private String Password;
	private int Phone;
	private String Adress;
	

	@OneToOne
	private Bank bank;
	
	
	
	//private String (long idbank)
}
