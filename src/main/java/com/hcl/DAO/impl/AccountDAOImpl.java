package com.hcl.DAO.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.hcl.DAO.AccountDAO;
import com.hcl.model.TransactionClass;

@Repository
public class AccountDAOImpl implements AccountDAO {
	Session session = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();

	@Override
	public void savetransactiondetails(int accountnumber,int transferamount,int toaccountno,String transactiontype) {
		System.out.println("Inside save transaction details method of AccountDAOImpl");
		Date date=new Date();
		Transaction t = session.beginTransaction();
		TransactionClass t1=new TransactionClass();
        t1.setAccountno(accountnumber);
        //t1.setTransactionid(count);
        t1.setAmount(transferamount);
        t1.setToaccountno(toaccountno);
        t1.setTransactiontype(transactiontype);
        t1.setDate(date);
        session.save(t1);
        t.commit();
		System.out.println("After closing session in AutoDAOImpl");

	}
	@Override
	public void savetransactiondetailsofotheruser(int accountnumber, int transferamount, int toaccountno) {
		Date date=new Date();
		Transaction t = session.beginTransaction();
		TransactionClass t1=new TransactionClass();
        t1.setAccountno(toaccountno);
        t1.setAmount(transferamount);
        t1.setToaccountno(accountnumber);
        t1.setTransactiontype("CREDIT");
        t1.setDate(date);
        session.save(t1);
        t.commit();
		System.out.println("After closing session in AutoDAOImpl of other user transaction");
	}
	@Override
	public void updateAccountdetailsofcurrentUser(int userid, int updatedbalanceofcurrentuser) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		String hql ="update Account set balance=:balance where userid=:userid";
		Query query = session.createQuery(hql);
		query.setInteger("balance", updatedbalanceofcurrentuser);
		query.setInteger("userid", userid);
		query.executeUpdate();
        t.commit();
	}
	@Override
	public void updateAccountdetailsofotherUser(int toaccountno, int transferamount,int balanceofotheruser) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		System.out.println("Inside updateAccountdetailsofotherUser method");
		int updatedbalance=transferamount+balanceofotheruser;
		System.out.println("*updated balance of other user inside method"+updatedbalance);
		String hql ="update Account set balance=:balance where accountno=:toaccountno";
		Query query = session.createQuery(hql);
		query.setInteger("balance", updatedbalance);
		query.setInteger("toaccountno", toaccountno);
		query.executeUpdate();
		t.commit();
    	}
	@Override
	public int getBalanceofOtherUser(int toaccountno) {
		List<Integer> balanceofotheruser;
		Transaction t = session.beginTransaction();
		String balancehql ="select balance from Account where accountno=:toaccountno";
		Query query = session.createQuery(balancehql);	
		query.setInteger("toaccountno", toaccountno);
		balanceofotheruser=query.list();
		System.out.println("balance of other user value:"+balanceofotheruser.get(0));
		t.commit();
		return (int) balanceofotheruser.get(0);
	}
	}
