package com.vvm.zeandiscovery;

import java.util.HashMap;
import java.util.Map;

/****
 * zengxiangcai
 * 2022/5/23 21:04
 ***/
public class Test {

    public static void main(String[] args) {

        String[] localArray = TestData.local167.split(", ");
        Map<String, String> localMap = new HashMap<>();
        for (String localCol : localArray) {
            localMap.put(localCol.split(" ")[0], localCol.split(" ")[1]);
        }

        String[] disArray = TestData.distribute167.split(", ");
        Map<String, String> disMap = new HashMap<>();
        for (String localCol : disArray) {
            disMap.put(localCol.split(" ")[0], localCol.split(" ")[1]);
        }

        for (Map.Entry<String, String> entry : localMap.entrySet()) {
            if (!disMap.containsKey(entry.getKey())) {
                //
                System.err.println("distribute not contain key" + entry.getKey());
            } else {
                String distributeType = disMap.get(entry.getKey()).trim();
                String localType = entry.getValue();
                if (!localType.trim().equals(distributeType.trim())) {
                    System.err.println("type miss match: distribute: " + distributeType + " , key:" + entry.getKey() + " " +
                            "localType: " + localType);
                }
            }


        }

        System.err.println("localSIze:" + localMap.size());
        System.err.println("localSIze:" + disMap.size());

    }
}
