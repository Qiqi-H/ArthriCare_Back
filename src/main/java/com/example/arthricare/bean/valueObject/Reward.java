package com.example.arthricare.bean.valueObject;

import java.util.Date;

public class Reward {

    private long userId;

    private boolean loginRewardClaimed;

    private Date loginRewardClaimedDate;

    public Reward(long userId, boolean loginRewardClaimed, Date loginRewardClaimedDate) {
        this.userId = userId;
        this.loginRewardClaimed = loginRewardClaimed;
        this.loginRewardClaimedDate = loginRewardClaimedDate;
    }


}
