package com.jzy.braindevelopment.game;

import java.io.Serializable;

public class PokerGame    implements Serializable {
    private Integer eachShowCardNum;       //每次显示的张数
    private Integer second;     //牌显示的秒数
    private Integer score=100;      //分数
    private int judgmentNum;    //错误次数
    private String gameRule="十组扑克拍，在规定的秒数内快速记忆扑克牌的花色和数字，然后根据记忆按顺序在选牌区选择数字花色相同的牌，正确翻玩所有牌即可进入下一组牌，记错一次扣十分,"
        +"初始分100分，选错一张牌扣10分并记录错误次数。分数为0时或记完十组牌游戏结束。";




    public String getGameRule() {
        return gameRule;
    }

    public void setGameRule(String gameRule) {
        this.gameRule = gameRule;
    }



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
