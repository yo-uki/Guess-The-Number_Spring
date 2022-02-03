package academy.programing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //== fields==
    private Game game;
    private MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //==events==

    @EventListener(ContextRefreshedEvent.class)
    public void start(){
        log.info("start() --> Container ready to use.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Can you guess the number?");

        while (true){
            System.out.println(messageGenerator.getMainMessage());

            int guess = scanner.nextInt();
            game.setGuess(guess);
            game.check();
            System.out.println(messageGenerator.getResultMessage());

            if (game.isGameWon() || game.isGameLost()){
                game.reset();

                System.out.println("Play again y/n ?");

                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("n")){
                    break;
                }
            }
        }
    }
}
