package tn.Dari.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.EqualsAndHashCode;
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

@EqualsAndHashCode


public class User implements Serializable, UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable =false)
	private Long user_id;
	//@NotEmpty(message = "User-Name may not be null")
	//@Size(min=3)
    //@Column(nullable=false)
	private String username;
	//@Column(nullable=false,unique=true)
	@NotEmpty
	@Email(regexp = ".+@.+\\..+" ,message="Please provide a valid email address")
	private String email;
	//@Column(nullable=false,unique=true)
	//@NotEmpty
    private String phone_number;
	
	@ValidPassword
    private String password;
	private boolean locked = false;
	private boolean enabled = false;
	@Enumerated(EnumType.STRING)
    private RoleName role;
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
	 * inverseJoinColumns = @JoinColumn(name = "role_id")) private Set<Role> roles=
	 * new HashSet<>();
	 */
      
    
    //Hajet ili teb3a userdetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
		return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
 	public boolean isEnabled() {
		return enabled;
	}

	public User(String username, String email, String phone_number, String password, RoleName role) {
		super();
		this.username = username;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
		this.role = role;
	}

	
	


	
	
	
	
	
	
	
	

}
