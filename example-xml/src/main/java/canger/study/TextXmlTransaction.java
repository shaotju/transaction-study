package canger.study;

import canger.study.service.ScoreService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextXmlTransaction {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");


        ScoreService scoreService = applicationContext.getBean(ScoreService.class);
        scoreService.getScore(1);
        scoreService.updateScore(1,99);

        applicationContext.close();
    }
}
