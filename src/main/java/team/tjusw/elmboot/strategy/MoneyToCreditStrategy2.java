package team.tjusw.elmboot.strategy;

public class MoneyToCreditStrategy2 extends MoneyToCreditStrategy {

    @Override
    public int moneyToCredit(double money) {
        // Convert money to credit with rounding
        int convertedCredit = (int) Math.round(money * 2);
        if (convertedCredit < 0) {
            throw new IllegalArgumentException("转换后的信用值不能为负数");
        }

        return convertedCredit;
    }

}
