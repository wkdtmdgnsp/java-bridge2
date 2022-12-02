package bridge.view;

import bridge.util.UserException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private UserException userException = new UserException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            int size = userException.bridgeSizeException(input);
            return size;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String move = Console.readLine();
            userException.movingException(move);
            return move;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String retry = Console.readLine();
            userException.retryException(retry);
            return retry;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
