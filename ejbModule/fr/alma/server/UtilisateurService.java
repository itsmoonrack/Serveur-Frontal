package fr.alma.server;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UtilisateurService implements UtilisateurRemote, UtilisateurLocal{
	@PersistenceContext
	EntityManager em;  

	@Override
	public Collection<Utilisateur> getUtilisateurs() {
		// TODO Auto-generated method stub
		String queryText = "from Utilisateur ";
		Query query = em.createQuery(queryText);
		@SuppressWarnings("unchecked")
		List<Utilisateur> books = query.getResultList();
		return books;
	}

	@Override
	public long addUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		em.persist(utilisateur);
		em.flush();
		return utilisateur.getId();
	}

	@Override
	public int removeUtilisateur(long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("delete from Utilisateur i "
                + "where i.id like :id");
		query.setParameter("id", id);
		int delete = query.executeUpdate();
		return delete;
	}

	@Override
	public void modifyUtilisateur(Utilisateur oldUtilisateur,
			Utilisateur newUtilisateur) {
		// TODO Auto-generated method stub
		
	}

}
