/**
 * 
 */
package ola.com.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

/**
 * @author User1
 *
 */

@WebServlet("/ride")
public class RideServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RideService rideService = new RideServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("book")) {
			Ride ride = new Ride();
			System.out.println("entering book section");
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ride.setDateTime(sqlDate);
			System.out.println("sqlDate value:"+sqlDate);
			
			ride.setRouteId(req.getParameter("routeId"));
			String rid=req.getParameter("routeId");
			
			System.out.println("routeId value:"+rid);
			
			ride.setUserId(req.getParameter("userId"));
			String userID=req.getParameter("userId");

			System.out.println("userid value:"+userID);
			rideService.BookRide(ride);
			req.setAttribute("ride", rideService.getRide());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/ride.jsp");
			rd.forward(req, resp);
		}
		System.out.println(req.getParameter("action"));
	}

}
