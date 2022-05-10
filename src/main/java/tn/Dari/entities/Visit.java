package tn.Dari.entities;

	
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.Dari.entities.Announcement;
import tn.Dari.entities.User;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visit implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisit;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dateVisit;
	private int heure;
	@Enumerated(EnumType.STRING)
	private VisitType visitType;

	@ManyToOne
	private Announcement announcement;

	@ManyToOne
	private User user;
}
