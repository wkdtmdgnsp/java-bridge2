package bridge.controller;

import bridge.view.InputView;

public class BridgeController {
    private InputView inputView = new InputView();

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        bridgeMake();
    }

    public void bridgeMake() {
        try {
            int size = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            bridgeMake();
        }
    }
}
