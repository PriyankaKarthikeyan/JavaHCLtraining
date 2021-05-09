package com.hcl.DAO;

import org.springframework.stereotype.Repository;
@Repository
public interface AccountDAO {


	void savetransactiondetails(int accountnumber, int transferamount, int toaccountno, String transactiontype);

	void savetransactiondetailsofotheruser(int accountnumber, int transferamount, int toaccountno);

	void updateAccountdetailsofcurrentUser(int userid, int updatedbalanceofcurrentuser);

	void updateAccountdetailsofotherUser(int toaccountno, int transferamount, int balanceofotheruser);

	int getBalanceofOtherUser(int toaccountno);
	}
