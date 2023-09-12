package com.example.arthricare.service;

import com.example.arthricare.bean.User;
import com.example.arthricare.mapper.RewardMapper;
import com.example.arthricare.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Service
public class UserRewardService {
    private final UserMapper userMapper;
    private final RewardMapper rewardMapper;

    public UserRewardService(UserMapper userMapper,RewardMapper rewardMapper) {
        this.userMapper = userMapper;
        this.rewardMapper = rewardMapper;

    }

    public int getPoint(int id)
    {
        return userMapper.findUserScoreById(id);
    }


    public void claimLoginReward(int id)
    {
        Date loginRewardClaimedDate = new Date();
        rewardMapper.claimLoginReward(false,loginRewardClaimedDate,id);
        userMapper.addPointsToUser(35,id);
    }

    public boolean checkLoginRewardClaimedStatue(long id)
    {
        return rewardMapper.getLoginRewardStatue(id);
    }

    public boolean determineLoginRewardCanBeClaimed(long id)
    {
        Date lastClaimDate = rewardMapper.getLastClaimLoginRewardDate(id);
        Date now = new Date();

        // 将上一次时间的日期部分加1天，然后将时间部分设置为 "5am"
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastClaimDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 获取第二天的 "5am" 时间
        Date nextDay5am = calendar.getTime();

        boolean result = now.after(nextDay5am);

        if(result)
        {
            rewardMapper.changeLoginRewardStatue(true,id);
        }

        //calendar.set(Calendar.HOUR_OF_DAY, 7);
        //Date now = calendar.getTime();


        return result;
    }

    public void claimProfileReward(int id)
    {
        rewardMapper.changeProfileRewardStatue(true,id);
        userMapper.addPointsToUser(100,id);
    }

    public boolean checkCompleteProfileStatue(long id)
    {
        return rewardMapper.getProfileRewardStatue(id);
    }

    public boolean determineCompleteProfileStatue(int id)
    {
        User user = userMapper.findUserById(id);

        boolean bName = user.getName().length()!=0;
        boolean bAge = user.getAge()!=0;
        boolean bGender = user.getGender().length()!=0;
        boolean bWeight = user.getWeight() != 0;

        System.out.println(bName);
        System.out.println(bAge);
        System.out.println(bGender);
        System.out.println(bWeight);
        if(bName && bAge && bGender && bWeight)
        {
            return true;
        }
        return false;
    }

    public void claimTakeMedicationReward(int userId)
    {
        userMapper.addPointsToUser(100,userId);
    }

}
