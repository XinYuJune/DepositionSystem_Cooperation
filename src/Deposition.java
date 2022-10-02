package src;

public class Deposition {
    double currentbalance = 0;
    String userName = "1班彭俊";
    int account = 20224924;

    public double getCurrentBalance() {
        return currentbalance;
    }

    public String getUserName() {
        return userName;
    }

    public int getAccount() {
        return account;
    }

    public void addBalance(double currentbalance) {
        if (currentbalance>0){
            this.currentbalance += currentbalance;
        }
        else {
            System.out.println("存入金额需大于0！");
        }
    }
}