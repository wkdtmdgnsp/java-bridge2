package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge = new ArrayList<>();
    private BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        bridgeMake();
        while (bridgeGame.isGameContinue() && bridge.size() > bridgeGame.getUp().size()) {
            move();
        }
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

    public void move() {
        try {
            String move = inputView.readMoving();
            bridgeGame.move(bridge, move);
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isGameContinue()) {
                retry();
            }
        } catch (IllegalArgumentException e) {
            move();
        }
    }

    public void retry() {
        try {
            String reGame = inputView.readGameCommand();
            if (reGame.contentEquals("R")) {
                bridgeGame.retry();
                return;
            }
        } catch (IllegalArgumentException e) {
            retry();
        }
    }
}
