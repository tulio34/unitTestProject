package builders;

import java.time.Instant;

import school.cesar.unit.project.EmailAccount;

public class EmailAccountBuilder {
	private EmailAccount emailAccountBuilder;
	public EmailAccountBuilder(){}
	
	public EmailAccountBuilder myAccount(){
		EmailAccountBuilder builder = new EmailAccountBuilder();
		builder.emailAccountBuilder = new EmailAccount();
		
		builder.emailAccountBuilder.setUser("tulio");
		builder.emailAccountBuilder.setDomain("live");
		builder.emailAccountBuilder.setPassword("123456");
		Instant instantExpired= Instant.ofEpochSecond( 1294881180 ); // 2011-01-13 01:13
		builder.emailAccountBuilder.setLastPasswordUpdate(instantExpired);
		return builder;
	}
	
	public EmailAccount getEmailAccount(){
		return this.emailAccountBuilder;
	}
}
