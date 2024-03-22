package ca.mcmaster.se2aa4.island.team118.ActionFactories;

import ca.mcmaster.se2aa4.island.team118.Actions.*;

public class JsonFactory implements ActionFactory {

    public FlyAction createFlyAction() {
        return new JsonFlyAction();
    }

    public HeadingAction createHeadingAction() {
        return new JsonHeadingAction();
    }

    public ScanAction createScanAction() {
        return new JsonScanAction();
    }

    public EchoAction createEchoAction() {
        return new JsonEchoAction();
    }

    public StopAction createStopAction() {
        return new JsonStopAction();
    }

}
