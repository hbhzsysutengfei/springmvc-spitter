package spittr.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpittleForm {
	
	@NotNull
	@Size(min=1, max=200)
	private String message;
	
	@Min(-180)
	@Max(180)
	private double longitude;
	
	@Min(-90)
	@Max(90)
	private double latitude;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	
	
}
