package ca.mcmaster.se2aa4.island.team118.ActionFactories;

import ca.mcmaster.se2aa4.island.team118.Actions.*;

public interface ActionFactory {

    public FlyAction createFlyAction();

    public HeadingAction createHeadingAction();

    public ScanAction createScanAction();

    public EchoAction createEchoAction();

    public StopAction createStopAction();
    
}
