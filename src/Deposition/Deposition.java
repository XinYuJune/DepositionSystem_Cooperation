package src.Deposition;

public class Deposition {
    //余额
    double currentBalance = 0;

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setcurrentBalance(double currentBalance) {
        if (currentBalance > 0) {
            this.currentBalance += currentBalance;
        } else {
            System.out.println("存入金额需大于0！");
        }
    }


}