package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.FilmFacade;
import model.Actor;
import model.Film;

@Path("/films")
public class FilmService {
	
	@EJB 
	FilmFacade filmFacadeEJB;
	
	Logger logger = Logger.getLogger(FilmService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Film> findAll(){
		return filmFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Film find(@PathParam("id") Integer id) {
        return filmFacadeEJB.find(id);
    }
	
	@GET
    @Path("{id}/actors")
    @Produces({"application/xml", "application/json"})
    public List<Actor> find_films(@PathParam("id") Integer id) {
        return filmFacadeEJB.find(id).sacarActors();
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Film entity) {
        filmFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Film entity) {
    	entity.setFilmId(id.intValue());
        filmFacadeEJB.edit(entity);
    }

}
