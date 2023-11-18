package team.tjusw.elmboot.domain;

import team.tjusw.elmboot.util.CommonUtil;

import java.math.BigDecimal;

public class VirtualWallet {
	private Integer walletId;
	private String createTime = CommonUtil.getCurrentDate();
	private BigDecimal balance;//余额
	private String userId;
	
	public int getwalletId() {
		return walletId;
	}
	public void setwalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public String getcreateTime() {
		return createTime;
	}
	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getbalance() {
		return balance;
	}
	public void setbalance(BigDecimal balance) {
		this.balance = balance;
	} 
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	
}
