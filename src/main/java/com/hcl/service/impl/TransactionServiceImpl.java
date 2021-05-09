package com.hcl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DAO.TransactionDAO;
import com.hcl.model.TransactionClass;
import com.hcl.service.TransactionService;

/**
 * @author yash.ghawghawe
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionDAO transactiondao;

	public TransactionClass gettransactiondetails(int accountnumber, int toaccountno, int transferamount) {
		return transactiondao.gettransactiondetails(accountnumber,toaccountno,transferamount);
	}


	@Override
	public List<TransactionClass> getTransactionItems(int accountnumber) {
		// TODO Auto-generated method stub
		return transactiondao.getTransactionItems(accountnumber);
	}

}