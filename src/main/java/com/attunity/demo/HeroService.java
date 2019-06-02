package com.attunity.demo;

import com.attunity.demo.model.Hero;
import com.github.javafaker.Faker;
import com.github.javafaker.GameOfThrones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class HeroService {
    @Autowired
    private HeroDao heroDao;

    private GameOfThrones gameOfThrones = new Faker().gameOfThrones();


    @EventListener(ContextRefreshedEvent.class)
    public void initDB(){
        for (int i = 0; i < 500; i++) {
            heroDao.save(Hero.builder().name(gameOfThrones.character()).build());
        }
    }
}
