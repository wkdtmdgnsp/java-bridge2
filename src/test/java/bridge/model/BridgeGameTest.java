package bridge.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 다리_이동_테스트1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(Arrays.asList("U"), "U");
        assertThat(bridgeGame.getUp()).isEqualTo(Arrays.asList("O"));
    }

    @Test
    void 다리_이동_테스트2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(Arrays.asList("U"), "D");
        assertThat(bridgeGame.getDown()).isEqualTo(Arrays.asList("X"));
    }
}