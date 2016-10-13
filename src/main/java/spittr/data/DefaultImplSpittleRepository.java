package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.model.Spittle;

@Component
public class DefaultImplSpittleRepository implements SpittleRepository {
	
	public DefaultImplSpittleRepository(){}

	public List<Spittle> findSpitters(long maxValue, int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i=0 ;i < count; i++){
			spittles.add(new Spittle("Spittle"+i, new Date()));
		}
		
		
		return spittles;
	}

}
