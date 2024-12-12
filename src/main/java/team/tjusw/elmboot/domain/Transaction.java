package team.tjusw.elmboot.domain;

import java.math.BigDecimal;

public class Transaction {
	private Integer transactionId;
	private String transactionDate;
	private BigDecimal transactionAmount;
	private Integer transactionType; // 0为支付，1为充值，2为提现
	private Integer entryWalletId; // 入账钱包 	提现时为null

	private Integer expendWalletId; //出账钱包 	充值时为null
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Integer getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getEntryWalletId() {
		return entryWalletId;
	}
	public void setEntryWalletId(Integer entryWalletId) {
		this.entryWalletId = entryWalletId;
	}
	public Integer getExpendWalletId() {
		return expendWalletId;
	}
	public void setExpendWalletId(Integer expendWalletId) {
		this.expendWalletId = expendWalletId;
	}
	

}
