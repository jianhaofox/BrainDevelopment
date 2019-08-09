package com.jzy.braindevelopment.game;

public class PokerGame {
    private Integer cardSum;    //总副数
    private Integer eachShowCardNum;       //每次显示的张数

    public Integer getCardSum() {
        return cardSum;
    }

    public void setCardSum(Integer cardSum) {
        this.cardSum = cardSum;
    }

    public Integer getEachShowCardNum() {
        return eachShowCardNum;
    }

    public void setEachShowCardNum(Integer eachShowCardNum) {
        this.eachShowCardNum = eachShowCardNum;
    }
}
