package tn.Dari.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.Dari.validation.ValidPassword;


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
	private Long user_id;
	@NotEmpty(message = "Name may not be null")
	@Size(min=3)
    @Column(nullable=false)
	private String first_name;
	@Column(nullable=false)
	@NotEmpty(message = "Last name may not be null")
	@Size(min=3)
	private String last_name;
	@Column(nullable=false,unique=true)
	@NotEmpty
	@Email(regexp = ".+@.+\\..+" ,message="Please provide a valid email address")
	private String email;
	@Column(nullable=false,unique=true)
	@NotEmpty
    private String phone_number;
	
	@ValidPassword
    private String password;

	private boolean locked;
	private boolean enabled;
	RoleName role;
	
	
	
	
	
	
	
	
	

}
