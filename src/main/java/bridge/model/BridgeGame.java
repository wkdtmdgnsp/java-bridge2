package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> up = new ArrayList<>();
    private List<String> down = new ArrayList<>();
    private int count = 0;
    private int gameCount = 1;
    private boolean gameContinue = true;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, String move) {
        if (bridge.get(count).contentEquals("U")) {
            moveUp(move);
            count++;
            return;
        }
        moveDown(move);
        count++;
    }

    private void moveUp(String move) {
        if (move.contentEquals("U")) {
            up.add(" O ");
            down.add("   ");
            return;
        }
        up.add("   ");
        down.add(" X ");
        gameContinue = false;
    }

    private void moveDown(String move) {
        if (move.contentEquals("D")) {
            up.add("   ");
            down.add(" O ");
            return;
        }
        up.add(" X ");
        down.add("   ");
        gameContinue = false;
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public int getGameCount() {
        return gameCount;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameContinue = true;
        up = new ArrayList<>();
        down = new ArrayList<>();
        count = 0;
        gameCount++;
    }
}
