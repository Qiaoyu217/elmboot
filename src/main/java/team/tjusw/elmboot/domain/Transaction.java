package team.tjusw.elmboot.domain;

import java.math.BigDecimal;

public class Transaction {
	private Integer transactionId;
	private String transactionDate;
	private BigDecimal transactionAmount;
	private int transactionType;// 0为支付，1为充值，2为提现
	private int entryWalletId;// 入账钱包 	提现时为null
	private int expendWalletId;//出账钱包 	充值时为null
	
	public int gettransactionId() {
		return transactionId;
	}
	public void settransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String gettransactionDate() {
		return transactionDate;
	}
	public void settransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal gettransactionAmount() {
		return transactionAmount;
	}
	public void settransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int gettransactionType() {
		return transactionType;
	}
	public void settransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public int getentryWalletId() {
		return entryWalletId;
	}
	public void setentryWalletId(int entryWalletId) {
		this.entryWalletId = entryWalletId;
	}
	public int getexpendWalletId() {
		return expendWalletId;
	}
	public void setexpendWalletId(int expendWalletId) {
		this.expendWalletId = expendWalletId;
	}
	

}
