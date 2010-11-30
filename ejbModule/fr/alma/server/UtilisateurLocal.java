package fr.alma.server;
import java.util.Collection;

import javax.ejb.Local;


@Local
public interface UtilisateurLocal {

	
	Collection<Utilisateur> getUtilisateurs();
	long addUtilisateur(Utilisateur utilisateur);
	int removeUtilisateur(long id);
	void modifyUtilisateur(Utilisateur oldUtilisateur, Utilisateur newUtilisateur);
	

}
