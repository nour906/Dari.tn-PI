package tn.Dari.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.Dari.entities.Visit;


@Entity
@Table(name="Users")
@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor


public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	@Column(nullable=false)
	private String first_name;
	@Column(nullable=false)
	private String last_name;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false,unique=true)
	private String phone_number;
	@Column(nullable=false) // à ajouter le longeur de mdp et les critéres de mdp !!
	private String password;
	
	 @ManyToMany 
	    @JoinTable( 
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<Role> roles;
	
		@OneToMany(mappedBy = "user")
		@JsonIgnore
		private Set<Visit> visits;
	
	
	
	
	
	
	
	

}
