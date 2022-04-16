package tn.Dari.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Visit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long id_v;
	Date hour_v;
	Date date_v;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Announcement announcements;


}
