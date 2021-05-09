package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hcl.model.TransactionClass;
@Service
public interface TransactionService {

	TransactionClass gettransactiondetails(int accountnumber, int toaccountno, int transferamount);

	List<TransactionClass> getTransactionItems(int accountnumber);

}
