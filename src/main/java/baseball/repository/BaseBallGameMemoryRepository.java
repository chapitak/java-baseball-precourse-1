package baseball.repository;

import baseball.domain.GameNumber;

public class BaseBallGameMemoryRepository implements BaseBallGameRepository {
    private static GameNumber gameNumber;

    @Override
    public void save(GameNumber targetNumber) {
        gameNumber = targetNumber;
    }

    @Override
    public GameNumber load() {
        return gameNumber;
    }
}
