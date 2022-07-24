package com.lab.springlab.async.repository;

import com.lab.springlab.async.model.Cake;
import com.lab.springlab.async.model.Coffee;
import com.lab.springlab.async.model.Menu;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CafeRepository {

    private Map<String, Menu> menuMap = new HashMap<>();

    @PostConstruct
    public void init() {
        menuMap.put("iceAmericano", new Coffee("iceAmericano", 4100));
        menuMap.put("latte", new Coffee("latte", 4500));
        menuMap.put("cheeseCake", new Cake("cheeseCake", 4500));
    }

    public int getPriceByName(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return menuMap.get(name).getPrice();
    }
}
