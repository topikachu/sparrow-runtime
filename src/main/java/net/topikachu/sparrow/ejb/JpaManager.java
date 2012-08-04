package net.topikachu.sparrow.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaManager {
	@PersistenceContext(unitName="sparrow-runtime") EntityManager em;
	public void saveEntity(Object e){
		em.persist(e);
	}
}
