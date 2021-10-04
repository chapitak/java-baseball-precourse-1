package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameResult;
import baseball.repository.BaseBallGameRepository;

public class BaseBallGameService {
    private final BaseBallGameRepository baseBallGameRepository;

    public BaseBallGameService(BaseBallGameRepository baseBallGameRepository) {
        this.baseBallGameRepository = baseBallGameRepository;
    }

    /**
     * 사용자 입력을 받아서 게임 결과를 연산한 후 결과를 문자열로 반환한다
     *
     * @param userNumber
     * @return
     */
    public String computeResult(String userNumber) {
        GameNumber gameNumber = GameNumber.fromUser(userNumber);
        GameResult gameResult = GameResult.computeResult(gameNumber, baseBallGameRepository.load());
        return gameResult.toResultString();
    }

    /**
     * 랜덤으로 생성한 GameNumber를 저장소에 저장한다
     */
    public void generateRandomNumber() {
        GameNumber targetNumber = GameNumber.random();
        baseBallGameRepository.save(targetNumber);
    }
}
