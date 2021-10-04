package baseball.repository;

import baseball.domain.GameNumber;

public interface BaseBallGameRepository {
    void save(GameNumber targetNumber);

    GameNumber load();
}
