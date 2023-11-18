package team.tjusw.elmboot.controller;

import team.tjusw.elmboot.domain.Transaction;
import team.tjusw.elmboot.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/VirtualWalletController")
public class VirtualWalletController {
	
	@Autowired
	private VirtualWalletService virtualwalletService;

	
	@RequestMapping("/getBalanceByUserId")
	public BigDecimal getBalanceByUserId(String userId) throws Exception{
		return virtualwalletService.getBalanceByUserId(userId);
	}
	
	@RequestMapping("/cashoutByWalletId")
	public int cashoutByWalletId(String userId, BigDecimal amount) throws Exception{
		return virtualwalletService.cashoutByWalletId(userId, amount);
	}
	
	@RequestMapping("/cashinByWalletId")
	public int cashinByWalletId(String userId, BigDecimal amount) throws Exception{
		return virtualwalletService.cashinByWalletId(userId, amount);
	}
	
	@RequestMapping("/getTransactionByUserId")
	public List<Transaction> getTransactionByUserId(String userId) throws Exception{
		return virtualwalletService.getTransactionByUserId(userId);
	}
	
	@RequestMapping("/payOrderByUserId")
	public int payOrderByUserId(String userId, BigDecimal orderTotal) throws Exception{
		return virtualwalletService.payOrderByUserId(userId, orderTotal);
	}
	
	
}
