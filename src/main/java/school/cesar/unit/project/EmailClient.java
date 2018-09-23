package school.cesar.unit.project;

import java.time.Instant;
import java.util.Collection;

public class EmailClient extends Email implements EmailServiceInterface {

	EmailServiceInterface emailServiceInterface;
	Collection<EmailAccount> accounts;
    EmailAccount emailAccount;

    public EmailServiceInterface getEmailService() {
		return emailServiceInterface;
	}

	public Collection<EmailAccount> getAccounts() {
		return accounts;
	}

	public EmailAccount getEmailAccount() {
		return emailAccount;
	}

	public void setAccounts(Collection<EmailAccount> accounts) {
		this.accounts = accounts;
	}

	public void setEmailAccount(EmailAccount emailAccount) {
		this.emailAccount = emailAccount;
	}

    public void setEmailService(EmailServiceInterface emailServiceInterface){
        this.emailServiceInterface = emailServiceInterface;
    }

    public boolean isValidAddress(String emailAddress){
    	CharSequence arroba = "@";
    	if (emailAddress.contains(arroba)) {
    		EmailAccount email = new EmailAccount();
    		
    		// divide o e-mail em "user@domain"
    		String palavras[] = new String[2];
    		palavras = emailAddress.split("@");
    		
    		// Posição 0 é o user; Posição 1 é o domain
    		email.setUser(palavras[0]);
    		email.setDomain(palavras[1]);
    		
    		// Só retorna true se os dois forem verdadeiros
    		return email.validaUserValido() && email.validaDomainValido();
    	}
    	return false;
    }

    public boolean isValidEmail(Email email){
        if (email.getCreationDate() != null &&
        	isValid(email.getTo()) &&
        	aoMenosUmValido(email.getFrom()) ) {

        	return true;
        }
        return false;
    }

    public boolean sendEmail(Email email){
        if (isValidEmail(email) == true){
        	return emailServiceInterface.sendEmail(email);
        }else{
        	throw new RuntimeException("E-mail Inválido, não foi possível enviar e-mail.");
        }
    }

    public boolean createAccount(EmailAccount account){
        if(account.validaUserValido() &&
           account.validaDomainValido() &&
           account.getPasswordLength() > 6){
        
        	account.setLastPasswordUpdate(Instant.now());
        	
        	//adicionar objeto a coleção accounts ****
			accounts.add(account);
        	return true;
        }
        return false;
    }
    
    /**
     * Método que valida os e-mail do destino
     * @param toCollection
     * @return true se a lista de e-mails for válida
     * @author tulio.menezes
     */
    public boolean isValid(Collection<String> toCollection) {
    	boolean emailValid = true;
    	for (String email : toCollection) {
    		if (!isValidAddress(email)) {
    			emailValid = false;
    			break;
    		}
    	}
    	return emailValid;
    }
    
    public boolean aoMenosUmValido(String from) {
    	boolean emailValid = false;
		if (isValidAddress(from)) {
			emailValid = true;
		}
    	return emailValid;
    }
    
    
    //verificar nos testes se esse verifyPasswordExpiration não está retornando falso
    // uma vez que será comparado com uma assertiva verdadeira
    public Collection<Email> emailList(EmailAccount account) {

		if (emailAccount.getPasswordLength() > 6 && emailAccount.verifyPasswordExpiration()) {
			return emailServiceInterface.emailList(account);
		}else{
			throw new RuntimeException();
		}
	}

}
