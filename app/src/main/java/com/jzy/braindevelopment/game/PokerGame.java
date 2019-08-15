package com.jzy.braindevelopment.game;

import java.io.Serializable;

public class PokerGame implements Serializable {
    private Integer eachShowCardNum;       //每次显示的张数
    private Integer second;     //牌显示的秒数
    private Integer score=100;      //分数
    private int judgmentNum;    //错误次数

    public Integer getJudgmentNum() {
        return judgmentNum;
    }

    public void setJudgmentNum(int judgmentNum) {
        this.judgmentNum = judgmentNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }




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
