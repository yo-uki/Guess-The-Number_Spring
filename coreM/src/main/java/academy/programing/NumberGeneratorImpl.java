package academy.programing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("generator")
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumb;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumb) {
        this.maxNumber = maxNumber;
        this.minNumb = minNumb;
    }

    // ==  methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumb) + minNumb;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumb() {
        return minNumb;
    }
}
