package com.example.renecontreras.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public  class Utils {


    /**
     *
     * @param number is the number to mask and it must be among 14-16 digits
     * @return masked number
     */
    public static String maskNumber(String number) {
        int numberLenght = number.length();

        if (numberLenght == 14) {
            number = number.substring(0, 6) + "XXXX" + number.substring(10, 14);
        }
        if (numberLenght == 15) {
            number = number.substring(0, 6) + "XXXXX" + number.substring(11, 15);
        }
        if (numberLenght == 16) {
            number = number.substring(0, 6) + "XXXXXX" + number.substring(12, 16);
        }
        return number;
    }

    /**
     *
     * @param number is the card number string to find the repeated number
     *               if two or more are found then chose the first one found
     * @return the repeated number in the card number string
     */
    public static char magicNumber(String number) {
        number.contains("s");
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char maxappearchar = ' ';
        for (int i = 0; i < number.length(); i++) {
            if (map.containsKey(number.charAt(i))) {
                map.put(number.charAt(i), map.get(number.charAt(i)) + 1);
            } else {
                map.put(number.charAt(i), 1);
            }
        }
        number.

        // it will return max value in the Hashmap
        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("the max char is : " + entry.getKey() + "  and displayed  " + maxValueInMap + "  times");     // Print the key with max value
                maxappearchar = entry.getKey();
            }
            char []array = number.toCharArray();
            Regex
        }
        return maxappearchar;
        Regex
    }


}
