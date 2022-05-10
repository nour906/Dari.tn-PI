package tn.Dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class Subscription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id_su; 
	String typeContract_su;
	float price_su;
	String model_su;
	
}
