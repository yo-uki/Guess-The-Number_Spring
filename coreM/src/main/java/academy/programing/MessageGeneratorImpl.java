package academy.programing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator{
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // ==fields==
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // ==init==
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "It's between " +
                game.getBiggest() +
                " and " +
                game.getSmallest();
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()){
            return "You won! Number was " +  game.getNumber();
        }else if (game.isGameLost()){
            return "You lost. The number was " + game.getNumber();
        }else if (!game.isValidNumberRange()) {
            return "Invalid number range.";
        } else if (game.getRemainingGuess() ==  game.getGuessCount()) {
            return "What's your first guess?";
        } else {
            String direction = "Higher";

            if (game.getNumber() < game.getGuess()){
                direction = "Lower";
            }

            return direction + "! You have " + game.getRemainingGuess() + " guesses left.";
        }
    }
}
