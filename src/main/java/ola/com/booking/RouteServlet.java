package ola.com.booking;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Route;
import ola.com.booking.service.RouteService;
import ola.com.booking.service.impl.RouteServiceImpl;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RouteService routeService = new RouteServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = (Integer) req.getAttribute("userId");
		System.out.println("routeservlet userid value"+id);
		req.setAttribute("userId", id);
		List<Route> routesvale = routeService.getRoutes();
		Iterator itr=routesvale.iterator();
		while(itr.hasNext()) {
			System.out.println("vlaues inside route list:"+itr.next());
		}
		req.setAttribute("rList", routeService.getRoutes()); 

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/routeview.jsp");
        rd.forward(req, resp);

	}

	
}
