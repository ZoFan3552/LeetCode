package everyday;

public class AccountBalanceAfterRoundedPurchase_2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 == 0){
            return 100 - purchaseAmount;
        }
        if (purchaseAmount < 10){
            if (purchaseAmount < 5){
                return 100;
            }
            return 90;
        }
        int temp = purchaseAmount / 10;
        double fraction = (double) purchaseAmount / 10 - temp;
        if (fraction >= 0.5){
            int roundedAmount = (purchaseAmount / 10 + 1) * 10;
            return 100 - roundedAmount;
        }else {
            return 100 - (purchaseAmount / 10) * 10;
        }
    }

    public static void main(String[] args) {
        int res = new AccountBalanceAfterRoundedPurchase_2806().accountBalanceAfterPurchase(15);
    }
}
