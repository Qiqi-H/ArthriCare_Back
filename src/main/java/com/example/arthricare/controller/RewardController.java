package com.example.arthricare.controller;


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
    public ResponseEntity<Integer> getUserById(@PathVariable("userId") Long userId) {
       int point = userRewardService.getPoint(userId);
       return ResponseEntity.ok(point);

    }

    @GetMapping("checkLoginRewardStatue/{userId}")
    public ResponseEntity<Boolean> checkLoginRewardStatue(@PathVariable Long userId)
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
    public void claimLoginReward(@PathVariable Long userId)
    {
        userRewardService.claimLoginReward(userId);
    }

    @GetMapping("checkProfileRewardStatue/{userId}")
    public ResponseEntity<Boolean> checkProfileRewardStatue(@PathVariable Long userId)
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
    public void claimProfileReward(@PathVariable Long userId)
    {
        userRewardService.claimProfileReward(userId);
    }

    @PutMapping("claimTakeMedicationReward/{userId}")
    public void claimTakeMedicationReward(@PathVariable Long userId)
    {
        userRewardService.claimTakeMedicationReward(userId);
    }
}
