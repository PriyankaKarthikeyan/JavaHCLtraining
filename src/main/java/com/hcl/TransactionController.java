package com.hcl;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.model.TransactionClass;
import com.hcl.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionservice;
	
	@RequestMapping(value = "/transactionhistory")
	public ModelAndView transactionhistory(@RequestParam("accountnumber") int accountnumber,@RequestParam("username") String username) throws Exception {
		System.out.println("Inside transaction history, account number:"+accountnumber);
		ModelAndView mv=new ModelAndView("transactionhistory");
		List<TransactionClass> transactionlist = transactionservice.getTransactionItems(accountnumber);
		mv.addObject("accountnumber",accountnumber);
		mv.addObject("username",username);
		mv.addObject("tlist",transactionlist); 
		return mv;
	}

}
