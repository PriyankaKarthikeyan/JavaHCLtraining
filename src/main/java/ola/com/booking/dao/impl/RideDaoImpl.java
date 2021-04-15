package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;
import ola.com.booking.model.User;

public class RideDaoImpl implements RideDao{

	
	

	Connection conn = ConectionManager.getConnection();

	@Override
	public void bookRide(Ride ride) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into ride (userId,routeId,dateTime) " + "values (?,?,?) ");
			statement.setString(1, ride.getUserId());
			statement.setString(2, ride.getRouteId());
			statement.setString(3, ride.getDateTime().toString());

			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Ride getRide() {
		Ride ride = new Ride();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from ride");
			while (rs.next()) {
				ride.setRideId(rs.getInt("rideId"));
				ride.setUserId(rs.getString("userId"));
				ride.setRouteId(rs.getString("routeId"));
				ride.setDateTime(rs.getDate("dateTime"));
			}
			return ride;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
