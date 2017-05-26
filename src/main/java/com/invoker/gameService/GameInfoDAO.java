package com.invoker.gameService;

import com.invoker.common.BaseDAO;
import com.invoker.entity.GameInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/5/25 at 0:57
 */
@Repository
public class GameInfoDAO extends BaseDAO<GameInfo> {
    @PostConstruct
    public void configDAO(){
        this.setEntity(new GameInfo());
    }
}
