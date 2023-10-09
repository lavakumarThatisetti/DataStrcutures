package Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

badge_records_1 = [
["Martha", "exit"],
["Paul", "enter"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "enter"],
["Paul", "enter"],
["Curtis", "exit"],
["Curtis", "enter"],
["Paul", "exit"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "exit"],
["Paul", "enter"],
["Paul", "enter"],
["Martha", "exit"],
]

Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]

n: length of the badge records array

 */
public class AccessControlCard {

    public static List<List<String>> analyzeRecords(final String[][] badgeRecords) {

        List<List<String>> ans = new ArrayList<>();

        Set<String> invalidExitList = new HashSet<>();
        Set<String> invalidEntryList = new HashSet<>();
        Map<String, Integer> stateMap = new HashMap<>();

        for (String[] record : badgeRecords) {

            if(!stateMap.containsKey(record[0]))
                stateMap.put(record[0],0);

            if (Objects.equals(record[1], "exit")) {
                if (stateMap.get(record[0])==1) {
                    stateMap.put(record[0],0);
                } else {
                    invalidExitList.add(record[0]);
                }
            } else { // enter
                if (stateMap.get(record[0])==0) {
                    stateMap.put(record[0],1);
                } else {
                    invalidEntryList.add(record[0]);
                }
            }
        }
        for(Map.Entry<String,Integer> entry: stateMap.entrySet()){
            if(entry.getValue() ==1){
                invalidEntryList.add(entry.getKey());
            }
        }

        ans.add(new ArrayList<>(invalidEntryList));
        ans.add(new ArrayList<>(invalidExitList));
        return ans;
    }

    public static void main(String[] args) {
        String[][] badgeRecords = {
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
        };
        System.out.println(analyzeRecords(badgeRecords));
    }
}
