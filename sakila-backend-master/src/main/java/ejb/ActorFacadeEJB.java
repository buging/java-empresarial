package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.ActorFacade;
import model.Actor;

@Stateless
public class ActorFacadeEJB extends AbstractFacade<Actor> implements ActorFacade {
	
	
	@PersistenceContext(unitName = "sakilaPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public ActorFacadeEJB() {
		super(Actor.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}
