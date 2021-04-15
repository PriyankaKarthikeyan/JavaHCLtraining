package ola.com.booking.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Ride {


	private int rideId;
	private String userId;
	private String routeId;
	Date dateTime;
	
	public int getRideId() {
		return rideId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
