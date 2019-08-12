package com.jzy.braindevelopment.game;

import java.io.Serializable;

public class PokerGame implements Serializable {
    private Integer eachShowCardNum;       //每次显示的张数
    private Integer second;     //牌显示的秒数


    public Integer getEachShowCardNum() {
        return eachShowCardNum;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public void setEachShowCardNum(Integer eachShowCardNum) {
        this.eachShowCardNum = eachShowCardNum;
    }
}
