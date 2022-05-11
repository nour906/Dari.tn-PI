package tn.Dari.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;




@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="announcements")
public class Announcement implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long  id_an;
	String description;
	String address;
	String lng;
	String lat;
	double phone;
	String city;
	String governorate;
	double price;
	Date date = new Date(System.currentTimeMillis());
	//@Lob
//	@Column(columnDefinition = "photo")
	//String img;
	//@Enumerated(EnumType.STRING)
	//Type type;
	
	@OneToMany(mappedBy = "announcement" ,cascade = CascadeType.ALL)
	public Set<Visit> visits;
}
