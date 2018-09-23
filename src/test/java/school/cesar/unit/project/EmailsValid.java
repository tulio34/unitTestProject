package school.cesar.unit.project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Instant;
import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import school.cesar.unit.project.EmailClient;
import school.cesar.unit.project.Email;

public class EmailsValid {
	
	private EmailClient emailClient;
	private Email email;
	
	@BeforeEach
	public void setup() {

		java.util.List<String> EmailsValidos = Arrays.asList("tulio@tulio.com", "testando@teste.com");

		email = new Email();
		email.setCreationDate(Instant.now());
		email.setTo(EmailsValidos);
		email.setFrom("amanda@email.com");
		email.setMessage("Teste de Message");
		email.setSubject("Teste de Subject");
		
		emailClient = new EmailClient();
	}
	
	@Test
	public void validaComArrobaEntreUsereDomain() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("t@live.com"));
	}
	
	@Test
	public void validaSemArrobaEntreUsereDomain() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAddress("tliv@eom"));
	}
	
	@Test
	public void isValidAdressSemUserAntesDoArroba() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAddress("@gmail.com"));
	}
}
