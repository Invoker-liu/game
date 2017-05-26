package com.invoker.web;

import com.invoker.entity.GameInfo;
import com.invoker.gameService.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/24 at 23:39
 */
@RestController
public class IndexController {
    @Autowired
    private GameService gameService;
    @RequestMapping(value = "game",method = RequestMethod.GET)
    public GameInfo findGame(){
        return gameService.findGame();
    }
}
