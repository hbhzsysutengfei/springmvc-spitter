package spittr.data;

import spittr.model.Spitter;

public interface SpitterRepository {

	public void save(Spitter spitter);

	public Spitter findbyUserName(String username);

}
