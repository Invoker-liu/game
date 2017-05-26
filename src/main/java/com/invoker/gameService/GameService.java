package com.invoker.gameService;

import com.invoker.entity.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2017/5/24 at 23:40
 */
@Service
public class GameService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private GameInfoDAO gameInfoDAO;
    public GameInfo findGame(){
        GameInfo gameInfo=new GameInfo();
        gameInfo.setName("绝地求生大逃杀");
        gameInfo.setType("大型逃生");
        gameInfoDAO.save(gameInfo);
        return gameInfoDAO.findById(2);
    }
}
