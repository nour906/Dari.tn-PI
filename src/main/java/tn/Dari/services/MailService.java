package tn.Dari.services;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import tn.Dari.entities.Agent;
import tn.Dari.entities.User;

public interface MailService {

	void Send(User user) throws MailException;

	void sendWithAttachment(User user, Agent agent, String attachement) throws MailException, MessagingException;

	void Sendd(String email, String body, String subject);

}
