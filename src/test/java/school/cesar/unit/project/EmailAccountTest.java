package school.cesar.unit.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import builders.EmailAccountBuilder;

public class EmailAccountTest {

	private EmailAccount emailAccount;
	EmailAccountBuilder emailAccountBuilder;

	@Test
	public void SeTruePasswordEstaExpirado() {
		// cenario
		emailAccountBuilder = new EmailAccountBuilder().myAccount();
		emailAccount = emailAccountBuilder.getEmailAccount();

		// ação
		emailAccount.verifyPasswordExpiration();
		// verificação
		// assertTrue(emailAccount.verifyPasswordExpiration());
		assertFalse(emailAccount.verifyPasswordExpiration());
	}

	@Test
	public void validaUserValido() {
		emailAccountBuilder = new EmailAccountBuilder().myAccount();
		emailAccount = emailAccountBuilder.getEmailAccount();

		assertTrue(emailAccount.validaUserValido());
	}

	@Test
	public void validaDomainValido() {
		emailAccountBuilder = new EmailAccountBuilder().myAccount();
		emailAccount = emailAccountBuilder.getEmailAccount();

		assertFalse(emailAccount.validaDomainValido());
	}

	
	@Test
	public void validaPasswordExpirado() {
		emailAccountBuilder = new EmailAccountBuilder().myAccount();
		emailAccount = emailAccountBuilder.getEmailAccount();

		assertFalse(emailAccount.verifyPasswordExpiration());
	}
	
	@Test
	public void validaPasswordValido() {
		emailAccountBuilder = new EmailAccountBuilder().myAccount();
		emailAccount = emailAccountBuilder.getEmailAccount();

		assertFalse(emailAccount.verifyPasswordExpiration());
	}
}
