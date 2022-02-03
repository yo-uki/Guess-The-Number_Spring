package academy.programing;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GamleImpl implements Game{

    // == constans ==
    private static final Logger log  = LoggerFactory.getLogger(GamleImpl.class);

    // == fields ==
    private final NumberGenerator numberGenerator;

    private final int guessCount;

     private int number;
     private  int guess;
     private  int smallest;
     private  int biggest;
     private int remainingGuesses;
     private boolean validNumberRange = true;

     // == constructors ==

    @Autowired
    public GamleImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }


//    public GamleImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    // == init  ==

    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumb();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy");
    }

    // == public methods ==
//    public void setNumberGenerator(NumberGenerator numberGenerator){ [SETTER]
//        this.numberGenerator = numberGenerator;
//    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
         this.guess = guess;

    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuess() {
        return remainingGuesses;
    }

    @Override
    public void check() {
         checkValidNumberRange();

         if (validNumberRange){
             if (guess > number){
                 biggest = guess -1;
             }
             if (guess < number){
                 smallest = guess +1;
             }
         }
         remainingGuesses--;

    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses == 0;
    }

    // == private methods ==
    private void checkValidNumberRange(){
         validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
