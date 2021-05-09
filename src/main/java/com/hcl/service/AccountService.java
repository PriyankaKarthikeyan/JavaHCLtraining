package com.hcl.service;

import org.springframework.stereotype.Service;
@Service
public interface AccountService {


	void savetransactiondetails(int accountnumber, int transferamount, int toaccountno, String transactiontype);

	void savetransactiondetailsofotheruser(int accountnumber, int transferamount, int toaccountno);

	void updateAccountdetailsofcurrentUser(int userid, int updatedbalanceofcurrentuser);

	int getBalanceofOtherUser(int toaccountno);

	void updateAccountdetailsofotherUser(int toaccountno, int transferamount, int balanceofotheruser);
}
