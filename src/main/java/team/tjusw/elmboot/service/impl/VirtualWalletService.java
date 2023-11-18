package team.tjusw.elmboot.service.impl;

import team.tjusw.elmboot.domain.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface VirtualWalletService {
	public int creatWalletByUserId(String userId);
	public BigDecimal getBalanceByUserId(String userId);
	public int cashoutByWalletId(String userId, BigDecimal amount);
	public int cashinByWalletId(String userId, BigDecimal amount);
	public List<Transaction> getTransactionByUserId(String userId);
	public int payOrderByUserId(String userId, BigDecimal orderTotal);
}
