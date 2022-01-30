package com.footballbettingcore.database;

public class BetReflectionsTotalled {
    private double totalMoneyOut;
    private double totalMoneyIn;
    private int numbBetsPlaced;

    public BetReflectionsTotalled() {
        this.numbBetsPlaced = 0;
        this.totalMoneyOut = 0;
        this.totalMoneyIn = 0;
    }

    public void addBet(double moneyOut, double odds, int resultBetOn, int result) {
        if (moneyOut > 0) {
            numbBetsPlaced++;
            totalMoneyOut += moneyOut;
        }

        if (resultBetOn == result) {
            totalMoneyIn += moneyOut * odds;
        }
    }

    public double getTotalMoneyOut() {
        return totalMoneyOut;
    }

    public double getTotalMoneyIn() {
        return totalMoneyIn;
    }

    public double getRealProfit() {
        return totalMoneyIn - totalMoneyOut;
    }

    public double getPercentageProfit() {
        return getRealProfit()*100 / totalMoneyOut;
    }

    public int getNumbBetsPlaced() {
        return numbBetsPlaced;
    }
}
