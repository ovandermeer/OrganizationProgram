/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author owenv
 */
import java.util.ArrayList;

public class Box {
    String label;
    String boxColor;
    ArrayList<String> boxContents;

    public Box(String label, String boxColor, ArrayList<String> boxContents) {
        this.label = label;
        this.boxColor = boxColor;
        this.boxContents = boxContents;
    }

    /**
     * Function: Checks to see if this box contains the searched item
     * Post-condition: Returns true if the boxContents array contains the searched item, and false if not
     */
    public boolean checkIfBoxContains(String itemName) {
        return boxContents.contains(itemName);
    }

    /**
     * Function: Serializes all data associated with this box into a JSON format
     * Post-condition: Returns a JSON formatted string that contains all the data associated with the box
     */
    public String exportToJSON() {
        String returnString = "{";

        returnString += "\"label\": \"" + label + "\",";
        returnString += "\"boxColor\": \"" + boxColor + "\",";
        returnString += "\"boxContents\": [";

        for(int i = 0; i < boxContents.size(); i++) {
            if(i != boxContents.size()-1) {
                returnString += "\"" + boxContents.get(i) + "\",";
            } else {
                returnString += "\"" + boxContents.get(i) + "\"";
            }
        }

        returnString += "]}";

        return returnString;
    }
}

