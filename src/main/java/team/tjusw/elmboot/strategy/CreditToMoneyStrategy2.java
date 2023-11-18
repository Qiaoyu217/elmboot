package team.tjusw.elmboot.strategy;

public class CreditToMoneyStrategy2 extends CreditToMoneyStrategy{

	@Override
	public double creditToMoney(Integer credit) {
		return credit * 0.02;
	}

	@Override
	public int moneyBackTocredit(double money) {
		// TODO Auto-generated method stub
		return (int)(money * 50);
	}

}
