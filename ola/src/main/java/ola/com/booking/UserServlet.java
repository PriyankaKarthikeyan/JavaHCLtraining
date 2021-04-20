package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.User;
import ola.com.booking.service.UserService;
import ola.com.booking.service.impl.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=0;
		if(req.getParameter("action").equals("register")) {
			User user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setPhoneNo(req.getParameter("phoneNo"));
			
			userService.saveUser(user);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
	        rd.forward(req, resp);
		}
		
		if(req.getParameter("action").equals("login")) {
			
		    //User user = userService.validateUser(req.getParameter("name"), req.getParameter("passowrd"));
			boolean isexist = userService.validateUser(req.getParameter("name"), req.getParameter("password"));
			try {
				userId=userService.getUserId(req.getParameter("name"), req.getParameter("password"));
				System.out.println("Fetched User id vakue"+userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("boolean alue of isexist:"+isexist);
			String uname =req.getParameter("name");
			String pass =req.getParameter("password");
			System.out.println("username-"+uname);
			System.out.println("pasword-"+pass);

			//instead of boolean get user object
			resp.setContentType("text/html;charset=UTF-8");
			System.out.println("after validation");
	        PrintWriter out = resp.getWriter();
	        
			if(isexist) {//user obj null or not
				RequestDispatcher rd = req.getRequestDispatcher("routes");
				System.out.println("successful validation");
				//send userId also
				//int id = user.getuserId();
				req.setAttribute("userId", userId);
	            rd.forward(req, resp);
			}
			else {
				System.out.println("unsuccessful validation");
				out.println("<font color='red'><b>You have entered incorrect password</b></font>");
	            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.html");
	            rd.include(req, resp);
			}
		}
		
		
		
	}

	
}
