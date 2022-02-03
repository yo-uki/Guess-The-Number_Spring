package academy.programing.config;

import academy.programing.GuessCount;
import academy.programing.MaxNumber;
import academy.programing.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/game.properties")
@ComponentScan(basePackages = "academy.programing")
public class GameConfig {

    @Value("${game.guessCount:20}")
    private int guessCount;

   @Value("${game.maxNumber:80}")
    private int maxNumber;

   @Value("${game.minNumber:0}")
   private int minNumber;

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

}
