package edu.md.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("edu.md.exam.mapper")
public class Springdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo2Application.class, args);
    }

}
