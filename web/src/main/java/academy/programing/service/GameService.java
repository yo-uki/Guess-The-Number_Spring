package academy.programing.service;

public interface GameService {

    boolean isGameOVer();

    String getMainMsg();

    String getResultMsg();

    void checkGuess(int guess);

    void reset();
}
