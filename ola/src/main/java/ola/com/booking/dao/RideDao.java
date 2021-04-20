package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;
import ola.com.booking.model.User;

public interface RideDao {

	void bookRide(Ride ride);
	Ride getRide();

}
