package com.example.renecontreras.myapplication.utils;

import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public  class Utils {


    /**
     *
     * @param number is the number to mask and it must be among 10-13 digits
     * @return masked number
     */
    public static String maskNumber(String number) {

        int numberLenght = number.length();
        Log.i("./MainActivity","lenght: "+numberLenght);

        if (numberLenght == 10) {
            number =  "***-***" + number.substring(6, 10);
        }
        if (numberLenght == 11) {
            number =  "+*-***-***" + number.substring(7, 11);
        }
        if (numberLenght == 12) {
            number =  "+**-***-***" + number.substring(8, 12);
        }
        if (numberLenght == 13) {
            number =  "+***-***-***" + number.substring(9, 13);
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

        // it will return max value in the Hashmap
        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("the max char is : " + entry.getKey() + "  and displayed  " + maxValueInMap + "  times");     // Print the key with max value
                maxappearchar = entry.getKey();
            }

        }
        return maxappearchar;
    }

    public static boolean isValidPhoneNumber(String number){
        number = number.replaceAll("[\\D]", "");
        Log.i("./MainActivity","number: "+number);
        if(number.length() >= 10 && number.length() <= 13 ){
            return true;
        }
        return false;


    }

}
