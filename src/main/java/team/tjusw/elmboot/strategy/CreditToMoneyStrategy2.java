package team.tjusw.elmboot.strategy;

public class CreditToMoneyStrategy2 extends CreditToMoneyStrategy {

    private static final double CREDIT_TO_MONEY_RATE = 0.02;
    private static final double MONEY_TO_CREDIT_RATE = 50;

    @Override
    public double creditToMoney(Integer credit) {
        return credit * CREDIT_TO_MONEY_RATE;
    }

    @Override
    public int moneyBackToCredit(double money) {
        return (int)(money * MONEY_TO_CREDIT_RATE);
    }

}
