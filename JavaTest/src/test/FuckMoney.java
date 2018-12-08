package test;

import common.Utils;

public class FuckMoney {
    //264478.87
    static final double startPerYear = 31181.88;
    //317374.60
//    static final double startPerYear = 37418.25;

    public static void main(String[] args) {
        double currentPerYearAllMoney = 0;
        for (int i = 0; i < 6; i++) {
            currentPerYearAllMoney = currentPerYearAllMoney * (1 + 0.0275 * 5) + startPerYear;
            Utils.log((i+1) * 5 + " year end,allMoney = " + currentPerYearAllMoney);
        }
    }
}
