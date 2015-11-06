package model;

import java.io.Serializable;

public class FilmActorId implements Serializable{
	
	private static final long serialVersionUID = 343L;
	
	private int actorId;
	private int filmId;
	
	public FilmActorId(int filmId, int actorId){
		this.actorId = actorId;
		this.filmId = filmId;
	}

	public int getActorId() {
		return actorId;
	}

	public int getFilmId() {
		return filmId;
	}
	
	@Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FilmActor) {
        	FilmActorId filmActorId = (FilmActorId) object;
            return ((filmActorId.filmId == this.filmId) && (filmActorId.actorId == this.actorId));
        }
        return false;
    }
	
 
	
}
