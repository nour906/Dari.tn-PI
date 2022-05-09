package tn.Dari.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Announcement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long  idan;
	Date date_an;
	String description_an;
	boolean availability; 
	String title_an;
	String location_an;
	Long rate_an;
	float Price;
	@Enumerated(EnumType.STRING)
	Type type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public User user;
	
	@OneToMany(mappedBy = "announcements")
	public Set<Visit> visits;

	public Long getId_an() {
		return idan;
	}

	public void setId_an(Long id_an) {
		this.idan = id_an;
	}

	public Date getDate_an() {
		return date_an;
	}

	public void setDate_an(Date date_an) {
		this.date_an = date_an;
	}

	public String getDescription_an() {
		return description_an;
	}

	public void setDescription_an(String description_an) {
		this.description_an = description_an;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getTitle_an() {
		return title_an;
	}

	public void setTitle_an(String title_an) {
		this.title_an = title_an;
	}

	public String getLocation_an() {
		return location_an;
	}

	public void setLocation_an(String location_an) {
		this.location_an = location_an;
	}

	public Long getRate_an() {
		return rate_an;
	}

	public void setRate_an(Long rate_an) {
		this.rate_an = rate_an;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
