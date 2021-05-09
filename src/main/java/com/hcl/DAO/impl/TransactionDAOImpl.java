package com.hcl.DAO.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hcl.ConnectionManager;
import com.hcl.DAO.AccountDAO;
import com.hcl.DAO.TransactionDAO;
import com.hcl.model.Account;
import com.hcl.model.TransactionClass;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	Session session = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();

	public TransactionClass gettransactiondetails(int accountnumber, int toaccountno, int transferamount) {
		// TODO Auto-generated method stub
		System.out.println("Inside save transaction details method");
		Date date =new Date();
		Calendar calobj = Calendar.getInstance();
		Transaction t = session.beginTransaction();
        TransactionClass t1=new TransactionClass();
        t1.setAccountno(accountnumber);
        t1.setAmount(transferamount);
        t1.setToaccountno(toaccountno);
        t1.setDate(date);
        session.save(t1);
        t.commit();
        return t1;
	}

	public List<TransactionClass> getTransactionItems(int accountnumber) {
		// TODO Auto-generated method stub
		System.out.println("Inside get transaction details method");
		List<TransactionClass> transactionlist=new ArrayList<TransactionClass>();
			System.out.println("account number:"+accountnumber);
			session.beginTransaction();
			String hql = "from TransactionClass where accountno= :accountno";
			Query query = session.createQuery(hql);
			query.setLong("accountno", accountnumber);
			transactionlist=query.list();
			System.out.println("After returning transaction items");	
			return transactionlist;
	}
}

