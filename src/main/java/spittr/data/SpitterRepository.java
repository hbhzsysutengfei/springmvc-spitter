package spittr.data;

import spittr.model.Spitter;

public interface SpitterRepository {

	void save(Spitter spitter);

	Spitter findbyUserName(String username);

}
