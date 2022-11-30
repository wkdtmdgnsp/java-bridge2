package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private List<String> bridge = new ArrayList<>();

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        bridgeMake();
    }

    public void bridgeMake() {
        try {
            int size = inputView.readBridgeSize();
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            bridgeMake();
        }
    }
}
