package team.tjusw.elmboot.strategy;

public class MoneyToCreditStrategy2 extends MoneyToCreditStrategy{

	@Override
	public int moneyToCredit(double money) {
		int creditNum = (int)(money * 2);
		return creditNum;
	}

}
