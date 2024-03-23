package ca.mcmaster.se2aa4.island.team118.ActionsTests;

import org.json.JSONObject;

public class JsonScanAction implements ScanAction{

    public String getString() {
        JSONObject scan = new JSONObject();
        scan.put("action","scan");
        return scan.toString();
    }
    
}
