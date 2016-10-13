package spittr.data;

import java.util.List;

import spittr.model.Spittle;

public interface SpittleRepository {
	public List<Spittle> findSpitters(long maxValue, int count);
}
