/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author owenv
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    String roomName;
    String wallColor;
    ArrayList<Box> boxList;
    ArrayList<String> boxTitleList;

    public Room(String roomName, String wallColor, ArrayList<Box> boxList, ArrayList<String> boxTitleList) {
        this.roomName = roomName;
        this.wallColor = wallColor;
        this.boxList = boxList;
        this.boxTitleList = boxTitleList;
    }

    /**
     * Function: Checks all the boxes in the room to see if any of them have the searched item in them
     * Post-condition: Returns a list of box objects that contain the searched item
     */
    public ArrayList<Box> checkBoxesForItem(String itemToSearch) {
        ArrayList<Box> returnList = new ArrayList<Box>();

        for(int i = 0; i < boxList.size(); i++) {
            if(boxList.get(i).checkIfBoxContains(itemToSearch)) {
                returnList.add(boxList.get(i));
            }
        }

        return returnList;
    }

    /**
     * Function: Serializes all data associated with this room into a JSON format
     * Post-condition: Returns a JSON formatted string that contains all the data associated with the room
     */
    public String exportToJSON() {
        String returnString = "{";

        returnString += "\"roomName\": \"" + roomName + "\",";
        returnString += "\"wallColour\": \"" + wallColor + "\",";
        returnString += "\"boxTitleList\": [";

        for(int i = 0; i < boxTitleList.size(); i++) {
            if(i != boxTitleList.size()-1) {
                returnString += "\"" + boxTitleList.get(i) + "\",";
            } else {
                returnString += "\"" + boxTitleList.get(i) + "\"";
            }
        }

        returnString += "],";
        returnString += "\"boxList\": [";

        for(int i = 0; i < boxList.size(); i++) {
            returnString += boxList.get(i).exportToJSON();
            if(i != boxList.size()-1) {
                returnString += ",";
            }
        }

        returnString += "]}";

        return returnString;
    }
}

