package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FilmFacade;
import model.Film;

@Stateless
public class FilmFacadeEJB extends AbstractFacade<Film> implements FilmFacade{

	@PersistenceContext(unitName = "sakilaPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public FilmFacadeEJB() {
		super(Film.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
}
