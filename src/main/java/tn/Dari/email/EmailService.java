package tn.Dari.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
private final static Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
private final JavaMailSender mailSender;
	

    @Override
    @Async //to not block the client from registring 
	public void send(String to, String email) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email, true);
			helper.setTo(to);
			helper.setSubject("Confirm Your email");
			helper.setFrom("nourelhouda.nciri@esprit.tn");
			mailSender.send(mimeMessage);
		}catch(MessagingException e) {
			LOGGER.error("Failed to send email" , e);
			throw new IllegalStateException("failed to send email");
		}
		
		
	}

}
