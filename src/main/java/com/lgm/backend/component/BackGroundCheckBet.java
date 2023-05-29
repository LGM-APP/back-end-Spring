package com.lgm.backend.component;

import com.lgm.backend.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BackGroundCheckBet {

    private final BetService betService;

    @Scheduled(fixedDelay = 1800000)
    public void run(){
        betService.checkBet();
    }

}
