package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hcl.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountservice;
	private final static Logger logger = Logger.getLogger(AccountController.class.getName());

	@RequestMapping(value = "/fundtranfer")
	public ModelAndView fundtransfer(@RequestParam("userid") int userid,@RequestParam("username") String username,@RequestParam("accountnumber") int accountnumber,@RequestParam("balance") int balance) throws Exception {
		System.out.println("Fundtranfer page...");
		ModelAndView mv=new ModelAndView("/fundtransfer");
		mv.addObject("userid", userid);
		mv.addObject("username", username);
		mv.addObject("balance", balance);
		mv.addObject("accountnumber", accountnumber);
		System.out.println("Returning the view page");	
		logger.info("Returning the view page");
		return mv;
	}	
	
	@RequestMapping(value = "/sumbittransfer")
	public ModelAndView sumbittransfer(@RequestParam("balance") int balance,Model model,@RequestParam("toaccountno") int toaccountno,@RequestParam("transferamount") int transferamount,@RequestParam("accountnumber") int accountnumber,@RequestParam("username") String username,@RequestParam("transactiontype") String transactiontype,@RequestParam("userid") int userid) throws Exception {
		int updatedbalanceofcurrentuser=0;
		String check="";
		int balanceofotheruser=0;
//		if(toaccountno==0 ||transferamount==0 || transactiontype.isEmpty() || transactiontype==""){
//			check="One or more fields are empty. Please fill it.";
//			model.addAttribute("check",check);
//			return new ModelAndView("/fundtransfer");
//		}
		System.out.println("Into submit transfer page");		
		ModelAndView mv=new ModelAndView("/balance");
		System.out.println("After setting balance view..");	
		logger.info("After setting balance view..");	
		updatedbalanceofcurrentuser=balance-transferamount;
		System.out.println("Before save transaction details method");
		logger.info("Before save transaction details method");
		balanceofotheruser=accountservice.getBalanceofOtherUser(toaccountno);
		accountservice.savetransactiondetails(accountnumber,transferamount,toaccountno,transactiontype);
		accountservice.savetransactiondetailsofotheruser(accountnumber,transferamount,toaccountno);	
		accountservice.updateAccountdetailsofcurrentUser(userid,updatedbalanceofcurrentuser);
		accountservice.updateAccountdetailsofotherUser(toaccountno, transferamount,balanceofotheruser);
		System.out.println("After save transaction details method");
		mv.addObject("toaccountno", toaccountno);
		mv.addObject("transferamount", transferamount);
		mv.addObject("accountnumber", accountnumber);
		mv.addObject("updatedbalance", updatedbalanceofcurrentuser);
		mv.addObject("username", username);
		mv.addObject("transactiontype",transactiontype);
		return mv;
	}
}
