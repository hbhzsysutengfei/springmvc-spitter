package spittr.data;

import org.springframework.stereotype.Component;

import spittr.model.Spitter;

@Component
public class DefaultImplSpitterRepository implements SpitterRepository {

	public void save(Spitter spitter) {

	}

	public Spitter findbyUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
