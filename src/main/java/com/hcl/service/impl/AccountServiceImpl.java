package com.hcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DAO.AccountDAO;
import com.hcl.model.Account;
import com.hcl.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
@Autowired
AccountDAO accountdao;

	@Override
	public void savetransactiondetails(int accountnumber, int transferamount, int toaccountno,String transactiontype) {
		accountdao.savetransactiondetails(accountnumber, transferamount, toaccountno,transactiontype);
	}

	@Override
	public void savetransactiondetailsofotheruser(int accountnumber, int transferamount, int toaccountno) {
		accountdao.savetransactiondetailsofotheruser(accountnumber,transferamount,toaccountno);		
	}

	@Override
	public void updateAccountdetailsofcurrentUser(int userid, int updatedbalanceofcurrentuser) {
		accountdao.updateAccountdetailsofcurrentUser(userid,updatedbalanceofcurrentuser);
	}

	@Override
	public void updateAccountdetailsofotherUser(int toaccountno, int transferamount,int balanceofotheruser) {
		accountdao.updateAccountdetailsofotherUser(toaccountno,transferamount,balanceofotheruser);
	}

	@Override
	public int getBalanceofOtherUser(int toaccountno) {
		return accountdao.getBalanceofOtherUser(toaccountno);
	}




	
}
