package builders;

import school.cesar.unit.project.Email;

public class EmailBuilder {
	private Email email;
	private Email emailBuilder;
	public EmailBuilder(){}
	
	public EmailBuilder myEmail(){
		EmailBuilder builder = new EmailBuilder();
		builder.email = new Email();
		builder.email.setCreationDate(null);
		builder.email.setFrom(null);
		builder.email.setTo(null);
		builder.email.setCc(null);
		builder.email.setBcc(null);
		builder.email.setSubject(null);
		builder.email.setMessage(null);
		return builder;
		
	}

	public Email getEmail() {
		// TODO Auto-generated method stub
		return this.emailBuilder;
	}
}
