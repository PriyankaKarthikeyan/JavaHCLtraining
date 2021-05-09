package com.hcl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "transaction")
public class TransactionClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transactionid")
	Long transactionid;
	@JoinColumn(referencedColumnName="accountno")
	int accountno;
	int toaccountno;
	int amount;
	Date date;
	String transactiontype;
	public Long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}
	public int getToaccountno() {
		return toaccountno;
	}
	public void setToaccountno(int toaccountno) {
		this.toaccountno = toaccountno;
	}

	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
}
