package com.example.mvc;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class MvcApplication {


    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

}
