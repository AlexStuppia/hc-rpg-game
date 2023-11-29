package org.ht.rpg.game.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan(basePackages = {
        "org.ht.rpg.game"

})

@EntityScan(basePackages = {
        "org.ht.rpg.game"

})


public class SpringBootMainClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainClassApplication.class, args);
    }
}
