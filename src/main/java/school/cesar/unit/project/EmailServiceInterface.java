package school.cesar.unit.project;

import java.util.Collection;

public interface EmailServiceInterface {
    
    boolean sendEmail(Email email);
    
    Collection<Email> emailList(EmailAccount account);
}