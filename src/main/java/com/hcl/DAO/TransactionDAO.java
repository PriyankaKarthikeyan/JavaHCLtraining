package com.hcl.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hcl.model.TransactionClass;
@Repository
public interface TransactionDAO {

	TransactionClass gettransactiondetails(int accountnumber, int toaccountno, int transferamount);

	List<TransactionClass> getTransactionItems(int accountnumber);

}
