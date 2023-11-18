package team.tjusw.elmboot.strategy;

public class MoneyToCreditStrategy1 extends MoneyToCreditStrategy{

	@Override
	public int moneyToCredit(double money) {
		int creditNum = (int)money;
		return creditNum;
	}

}
