package com.example.arthricare.bean.valueObject;

import java.util.Date;

public class loginReward {


    private boolean canClaimedLoginReward;
    private int puzzleNum;

    public loginReward(boolean canClaimedLoginReward, int puzzleNum) {
        this.canClaimedLoginReward = canClaimedLoginReward;
        this.puzzleNum = puzzleNum;
    }

    public boolean isCanClaimedLoginReward() {
        return canClaimedLoginReward;
    }

    public void setCanClaimedLoginReward(boolean canClaimedLoginReward) {
        this.canClaimedLoginReward = canClaimedLoginReward;
    }

    public int getPuzzleNum() {
        return puzzleNum;
    }

    public void setPuzzleNum(int puzzleNum) {
        this.puzzleNum = puzzleNum;
    }

    @Override
    public String toString() {
        return "loginReward{" +
                "canClaimedLoginReward=" + canClaimedLoginReward +
                ", puzzleNum=" + puzzleNum +
                '}';
    }
}
