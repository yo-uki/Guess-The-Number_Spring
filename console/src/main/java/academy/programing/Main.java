package academy.programing;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        SpringApplication.run(Main.class, args);

        // create context (container) //SPRING BOOT ROBI KONTEKST SAM
       // ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // get number bean context  (container)
       // NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // get message bean context (container)
        //MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // call method next() to get random number
        //int number = numberGenerator.next();

        //log.info("number = {}", number);

        // get game bean context  (container)
        //Game game = context.getBean(GamleImpl.class);

        //call reset method
        //game.reset();


        // close context (container)
       // context.close();

    }
}
