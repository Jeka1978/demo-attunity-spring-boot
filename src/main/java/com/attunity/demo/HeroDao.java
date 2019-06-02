package com.attunity.demo;

import com.attunity.demo.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface HeroDao extends CrudRepository<Hero,Integer> {

    List<Hero> findByNameContains(@RequestParam("name") String name);
}
