package baseball.util.ResultHandler;

import baseball.util.resultFomat.BallAndStrikeFormatter;
import baseball.util.resultFomat.ResultFormatter;

public class BallAndStrikeHandler implements ResultHandler {

    @Override
    public void setNextHandler(ResultHandler nextHandler) {
    }

    @Override
    public ResultFormatter handleResult(int ball, int strike) {
        return new BallAndStrikeFormatter(ball, strike);
    }
}