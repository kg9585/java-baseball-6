package baseball.model;

import java.util.Map;
import java.util.stream.IntStream;

public class UserComputerCompare {
    private final Computer computer;
    private final Player player;
    private final Result result;

    private UserComputerCompare(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        this.result = Result.initialBallCount();
    }

    public static UserComputerCompare judge(Computer computer, Player player) {
        return new UserComputerCompare(computer, player);
    }


    public Map<BallCount, Integer> getBallCountJudgement() {
        IntStream.range(0, 3)
                .forEach(this::processPlayerNumber);

        return result.getResult();
    }

    private void processPlayerNumber(int index) {
        int playerNumber = player.getNumberByPosition(index);
        boolean hasCommonNumber = hasCommonNumber(playerNumber);
        boolean isInSamePosition = isInSamePosition(index, playerNumber);

        BallCount key = BallCount.decideBallCount(hasCommonNumber, isInSamePosition);
        if (key != BallCount.NOTHING) {
            result.updateBallCount(key);
        }
    }

    private boolean isInSamePosition(int position, int number) {
        return computer.getNumberByPosition(position) == number;
    }

    private boolean hasCommonNumber(int number) {
        return computer.getComputerNumber().contains(number);
    }
}