package academy.programing.service;

import academy.programing.Game;
import academy.programing.MessageGenerator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService{

    @Getter
    final Game game;

    @Getter
    final MessageGenerator msgGenerator;

    @Autowired
    public GameServiceImpl( Game game,@ModelAttribute MessageGenerator msgGenerator) {
        this.game = game;
        this.msgGenerator = msgGenerator;
    }

    // ==methods==

    @PostConstruct
    void initGame(){
        log.info("ZAINICJOWANO GRE: liczba = {}. Wiadomość: {}",game.getNumber(),msgGenerator.getMainMessage());
    }

    @Override
    public boolean isGameOVer() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMsg() {
        return msgGenerator.getMainMessage();
    }

    @Override
    public String getResultMsg() {
        return msgGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
