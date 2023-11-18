package team.tjusw.elmboot.strategy;

public class CreditToMoneyStrategy1 extends CreditToMoneyStrategy{

	@Override
	public double creditToMoney(Integer credit) {
		return credit * 0.01;
	}

	@Override
	public int moneyBackTocredit(double money) {
		// TODO Auto-generated method stub
		return (int)(money * 100);
	}

}
