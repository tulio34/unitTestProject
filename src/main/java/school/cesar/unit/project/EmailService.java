package school.cesar.unit.project;

import java.util.ArrayList;
import java.util.Collection;

public class EmailService implements EmailServiceInterface {
	
	Collection<Email> emailDosUsuarios = new ArrayList<Email>();

	public boolean sendEmail(Email email) {
		// TODO Auto-generated method stub
		if (emailDosUsuarios.add(email)) {
			return true;
		}
		return false;
	}

	public Collection<Email> emailList(EmailAccount account) {
		// TODO Auto-generated method stub
		Collection<Email> emailsDoUsuario = new ArrayList<Email>();
		
		for (Email email : emailDosUsuarios) {
			if (email.getFrom().equals(account.getUser()+"@"+account.getDomain())) {
				emailsDoUsuario.add(email);
			}
		}
		
		return emailsDoUsuario;
	}

	
}
