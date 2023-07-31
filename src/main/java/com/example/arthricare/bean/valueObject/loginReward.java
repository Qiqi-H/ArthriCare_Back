package com.example.arthricare.bean.valueObject;

import java.util.Date;

public class loginReward {


    private boolean loginRewardClaimed;

    private Date loginRewardClaimedDate;

    private int point;

    public loginReward(boolean loginRewardClaimed, Date loginRewardClaimedDate) {
        this.loginRewardClaimed = loginRewardClaimed;
        this.loginRewardClaimedDate = loginRewardClaimedDate;
        this.point = 35;
    }

}
