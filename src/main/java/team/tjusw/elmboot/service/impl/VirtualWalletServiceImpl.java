package team.tjusw.elmboot.service.impl;

import team.tjusw.elmboot.domain.Transaction;
import team.tjusw.elmboot.domain.VirtualWallet;
import team.tjusw.elmboot.mapper.TransactionMapper;
import team.tjusw.elmboot.mapper.VirtualWalletMapper;
import team.tjusw.elmboot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService{
	
	@Autowired
	private VirtualWalletMapper virtualwalletMapper;
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Override
	public int creatWalletByUserId(String userId) {
		VirtualWallet virtualwallet = new VirtualWallet();
		virtualwallet.setcreateTime(CommonUtil.getCurrentDate());
		virtualwallet.setuserId(userId);
		virtualwallet.setbalance(BigDecimal.ZERO);
		return virtualwalletMapper.creatWalletByUserId(virtualwallet);
	}
	
	@Override
	public BigDecimal getBalanceByUserId(String userId) {
		return virtualwalletMapper.getBalanceByUserId(userId);
	}
	
	@Override
	public int cashoutByWalletId(String userId, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO)<=0) return 0;
		BigDecimal mybalance = virtualwalletMapper.getBalanceByUserId(userId);
		if (mybalance.compareTo(amount) < 0) return 0;
		int flag1 = virtualwalletMapper.subtractVirtualWalletByUserId(userId, amount);
		Transaction transaction = new Transaction();
		transaction.settransactionDate(CommonUtil.getCurrentDate());
		transaction.settransactionType(2);
		transaction.settransactionAmount(amount);
		int expendWalletId = virtualwalletMapper.getWalletIdByUserId(userId);
		transaction.setexpendWalletId(expendWalletId);
		transaction.setentryWalletId(0);
		int flag2 = transactionMapper.insertTransaction(transaction);
		return flag1&flag2;
	}
	
	@Override
	public int cashinByWalletId(String userId, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO)<=0) return 0;
		int flag1 = virtualwalletMapper.addVirtualWalletByUserId(userId, amount);
		
		Transaction transaction = new Transaction();
		transaction.settransactionDate(CommonUtil.getCurrentDate());
		transaction.settransactionType(1);
		transaction.settransactionAmount(amount);
		int entryWalletId = virtualwalletMapper.getWalletIdByUserId(userId);
		transaction.setentryWalletId(entryWalletId);
		transaction.setexpendWalletId(0);
		int flag2 = transactionMapper.insertTransaction(transaction);
		return flag1&flag2;
	}
	
	@Override
	public List<Transaction> getTransactionByUserId(String userId){
		int walletId = virtualwalletMapper.getWalletIdByUserId(userId);
		return transactionMapper.getTransactionByWalletId(walletId);
	}
	
	@Override
	public int payOrderByUserId(String userId, BigDecimal orderTotal) {
		BigDecimal mybalance = virtualwalletMapper.getBalanceByUserId(userId);
		if (mybalance.compareTo(orderTotal) < 0) return 0;
		int flag1 = virtualwalletMapper.subtractVirtualWalletByUserId(userId, orderTotal);
		Transaction transaction = new Transaction();
		transaction.settransactionDate(CommonUtil.getCurrentDate());
		transaction.settransactionType(0);
		transaction.settransactionAmount(orderTotal);
		int expendWalletId = virtualwalletMapper.getWalletIdByUserId(userId);
		transaction.setexpendWalletId(expendWalletId);
		transaction.setentryWalletId(88888);//商家的钱包id均为88888
		int flag2 = transactionMapper.insertTransaction(transaction);
		return flag1&flag2;
	}
	
}
