package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FilmActorFacade;
import model.FilmActor;

@Stateless
public class FilmActorFacadeEJB  extends AbstractFacade<FilmActor> implements FilmActorFacade{

	@PersistenceContext(unitName = "sakilaPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public FilmActorFacadeEJB() {
		super(FilmActor.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}