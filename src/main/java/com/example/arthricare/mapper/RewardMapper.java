package com.example.arthricare.mapper;

import com.example.arthricare.bean.Medication;
import com.example.arthricare.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
@Mapper
public interface RewardMapper {

    @Insert("INSERT INTO rewards (user_id) VALUES " + "(#{id})")
    void createReward(long id);

    @Update("UPDATE rewards SET loginRewardClaimed = #{loginRewardClaimed}, loginRewardClaimedDate = #{loginRewardClaimedDate} WHERE user_id = #{id}")
    void claimLoginReward(boolean loginRewardClaimed, Date loginRewardClaimedDate,long id);

    @Update("UPDATE rewards SET loginRewardClaimed = #{loginRewardClaimed} WHERE user_id = #{id}")
    void changeLoginRewardStatue(boolean loginRewardClaimed, long id);

    @Select("SELECT loginRewardClaimedDate from rewards WHERE user_id = #{id}")
    Date getLastClaimLoginRewardDate(long id);

    @Select("SELECT loginRewardClaimed from rewards WHERE user_id = #{id}")
    boolean getLoginRewardStatue(long id);

    @Select("SELECT profileRewardClaimed from rewards WHERE user_id = #{id}")
    boolean getProfileRewardStatue(long id);

    @Update("UPDATE rewards SET profileRewardClaimed = #{profileRewardClaimed} WHERE user_id = #{id}")
    void changeProfileRewardStatue(boolean profileRewardClaimed, long id);

    @Update("UPDATE rewards SET puzzle_num = puzzle_num+1 WHERE user_id = #{id}")
    void updatePuzzleNum(long id);

    @Select("SELECT puzzle_num from rewards WHERE user_id = #{id}")
    int getPuzzleNum(long id);
}
