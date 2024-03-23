package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

public class JsonScanAction implements ScanAction{

    /**
    Create a new JSONObject, put the keys and values
    to call an 'scan' action.

    @return string     the string representing the
                       corresponding JSON Object
    */
    public String getString() {
        JSONObject scan = new JSONObject();
        scan.put("action","scan");
        return scan.toString();
    }
    
}
