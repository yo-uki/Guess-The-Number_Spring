package academy.programing.controller;

import academy.programing.service.GameService;
import academy.programing.util.AttributeNames;
import academy.programing.util.Mappings;
import academy.programing.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // ==request methods ==

    @GetMapping(Mappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MSG, gameService.getMainMsg());
        model.addAttribute(AttributeNames.RESULT_MSG, gameService.getResultMsg());
        log.info("moj model = {}",model);
        if (gameService.isGameOVer()){
            return ViewNames.OVER;
        }
        return ViewNames.GAME;
    }

    @PostMapping(Mappings.PLAY)
    public String processMsg(@RequestParam int guess){
        log.info("guess = {}",guess);
        gameService.checkGuess(guess);
        return Mappings.REDIRECT;
    }

    @GetMapping("restart")
    public String restart(){
        gameService.reset();
        return Mappings.PLAY;
    }
}
