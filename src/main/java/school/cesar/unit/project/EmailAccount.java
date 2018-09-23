package school.cesar.unit.project;

import java.time.Instant;

public class EmailAccount {
    private String user;
    private String domain;
    private String password;
    private Instant lastPasswordUpdate;

	public void setLastPasswordUpdate(Instant lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }
    
    public boolean validaUserValido(){
    	return user.matches("[(.)|(\\-)|(_)0-9a-zA-Z]+");
    }
    
    public boolean validaDomainValido(){
    	return domain.matches("\\b((?=[a-z0-9-]{1,}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\b");
    }
    
    public boolean verifyPasswordExpiration(){
    	Instant dataAtual = Instant.now();
    	
    	// Quantidade de segundos que tem em 90 dias
    	long noventaDiasemSegundos = 7776000;
    	
    	// Se a compara��o retornar um n�mero maior que zero, � porque � maior que 90 dias
    	// true se estiver expirado
    	return lastPasswordUpdate.compareTo(dataAtual.plusSeconds(noventaDiasemSegundos)) > 0;
    }

	public String getUser() {
		return user;
	}

	public String getDomain() {
		return domain;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPasswordLength() {
		// TODO Auto-generated method stub
		return password.length();
	}
    
}
