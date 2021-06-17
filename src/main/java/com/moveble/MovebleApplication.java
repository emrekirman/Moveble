package com.moveble;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;


@SpringBootApplication
public class MovebleApplication {

    public static void main(String[] args){
        SpringApplication.run(MovebleApplication.class,args);
    }
}
