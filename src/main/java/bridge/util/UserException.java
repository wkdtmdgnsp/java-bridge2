package bridge.util;

public class UserException {
    public int bridgeSizeException(String input) {
        try {
            int size = bridgeSizeNumberException(input);
            bridgeSizeRangeException(size);
            return size;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public int bridgeSizeNumberException(String input) {
        try {
            int size = Integer.parseInt(input);
            return size;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void bridgeSizeRangeException(int size) {
        if (size < 3 || size > 20) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void movingException(String move) {
        if (!move.contentEquals("U") && !move.contentEquals("D")) {
            System.out.println("[ERROR] U 또는 D를 입력 해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void retryException(String retry) {
        if (!retry.contentEquals("R") && !retry.contentEquals("Q")) {
            System.out.println("[ERROR] R 또는 Q를 입력 해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
