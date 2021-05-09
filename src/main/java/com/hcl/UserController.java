package com.hcl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;
import com.hcl.service.AccountService;
import com.hcl.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;

	@RequestMapping(value = "/")
	public String goToUserHome() throws Exception {
		System.out.println("Redirecting to login form");
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("user")User user, @RequestParam("username") String username,
			@RequestParam("password") String password, BindingResult result,Model model) throws Exception {
		System.out.println("Before getting userID");
		String check = "";
		// int userid=user.getUserid();
		System.out.println("inside validate method");
		if (username.equals("")|| password.equals("")|| username.isEmpty()|| password.isEmpty()) {
			check="Username/Password cannot be empty!";
			model.addAttribute("check",check);
			return new ModelAndView("/login");
		}
		int idofuser = userservice.validate(username, password);
		System.out.println("before true");
		if (idofuser != 0) {
			System.out.println("if boolean true");
			List<Integer> accountdetailsOfUser = userservice.getUserAccountdetails(idofuser);
			int accountnumber = accountdetailsOfUser.get(0);
			int balance = accountdetailsOfUser.get(1);
			System.out.println("Go to account page!");
			ModelAndView mv = new ModelAndView("/accountdetails");
			mv.addObject("username", username);
			mv.addObject("userid", idofuser);
			mv.addObject("accountnumber", accountnumber);
			mv.addObject("balance", balance);
			mv.addObject("accountdetailsOfUser", accountdetailsOfUser);
			return mv;
		} else {
			System.out.println("unsuccessful validation");
			ModelAndView mv = new ModelAndView("/invalid");
			return mv;
		}
	}

}
