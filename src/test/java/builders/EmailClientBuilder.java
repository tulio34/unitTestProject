package builders;

import school.cesar.unit.project.EmailClient;

public class EmailClientBuilder {
	private EmailClient emailClientBuilder;
	public EmailClientBuilder(){}
	
	public EmailClientBuilder myClient(){
		EmailClientBuilder builder = new EmailClientBuilder();
		builder.setEmailClientBuilder(new EmailClient());
		
		builder.emailClientBuilder.setAccounts(null);
		builder.emailClientBuilder.setEmailService(null);
		builder.emailClientBuilder.setEmailAccount(null);
		return builder;
		
	}
	
	

	public EmailClient getEmailClient() {
		return getEmailClient();
	}

	public void setEmailClient(EmailClient emailClient) {
		this.emailClientBuilder = emailClient;
	}

	public EmailClient getEmailClientBuilder() {
		return emailClientBuilder;
	}

	public void setEmailClientBuilder(EmailClient emailClientBuilder) {
		this.emailClientBuilder = emailClientBuilder;
	}
}
