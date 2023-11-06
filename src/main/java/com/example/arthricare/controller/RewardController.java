package com.example.arthricare.controller;


import com.example.arthricare.bean.valueObject.loginReward;
import com.example.arthricare.service.UserRewardService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Resource
    private final UserRewardService userRewardService;

    public RewardController(UserRewardService userRewardService) {
        this.userRewardService = userRewardService;
    }

    @GetMapping("findPointByUserId/{userId}")
    public ResponseEntity<Integer> getUserById(@PathVariable("userId") int userId) {
       int point = userRewardService.getPoint(userId);
       return ResponseEntity.ok(point);

    }

    @GetMapping("getPuzzleNumByUserId/{userId}")
    public ResponseEntity<Integer> getPuzzleNumByUserId(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(userRewardService.getPuzzleNum(userId));

    }

    @GetMapping("checkLoginRewardStatue/{userId}")
    public ResponseEntity<Boolean> checkLoginRewardStatue(@PathVariable int userId)
    {
        if(userRewardService.checkLoginRewardClaimedStatue(userId)||userRewardService.determineLoginRewardCanBeClaimed(userId))
        {
            return ResponseEntity.ok(true);
        }
        else
        {
            return ResponseEntity.ok(false);
        }

    }

    @PutMapping("claimLoginReward/{userId}")
    public void claimLoginReward(@PathVariable int userId)
    {
        userRewardService.claimLoginReward(userId);
    }

    @GetMapping("checkProfileRewardStatue/{userId}")
    public ResponseEntity<Boolean> checkProfileRewardStatue(@PathVariable int userId)
    {
        if (!userRewardService.checkCompleteProfileStatue(userId))
        {
            if(userRewardService.determineCompleteProfileStatue(userId))
            {
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.ok(false);
    }

    @PutMapping("claimProfileReward/{userId}")
    public void claimProfileReward(@PathVariable int userId)
    {
        userRewardService.claimProfileReward(userId);
    }

    @PutMapping("claimTakeMedicationReward/{userId}")
    public void claimTakeMedicationReward(@PathVariable int userId)
    {
        userRewardService.claimTakeMedicationReward(userId);
    }
}
