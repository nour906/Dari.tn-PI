package tn.Dari.registration;

  
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import tn.Dari.validation.ValidPassword;
//Lors de creation d'un compte on a besoin de recuperer certaines informations
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistrationRequest {
	@NotEmpty(message = "User-Name may not be null")
	@Size(min=3)
    private String username;
	@NotEmpty
	@Email(regexp = ".+@.+\\..+" ,message="Please provide a valid email address")
	private String email;
	@NotEmpty
    private String phone_number;
	@ValidPassword
    private String password;
}
