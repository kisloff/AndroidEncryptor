package ru.k_kiselev.zilabandroid.utils;

import ru.k_kiselev.zilabandroid.encryption.EncryptionProtocol;

import java.util.regex.Pattern;

public class StringUtils {

    public final static String BINARY_PATTERN = "[01]";

    public static String completeString(String string){
        int diff = EncryptionProtocol.SIZE - string.length();

        if(diff > 0){
            for(int i = diff; i > 0; i--){
                string = "0" + string;
            }
        }
        return string;
    }

    public static boolean isBinary(String string){
        return Pattern.compile(BINARY_PATTERN).matcher(string).find();
    }

    public static int[] convertStringToArray(String string) {
        int length = string.length();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            int value = Integer.parseInt(String.valueOf(string.charAt(i)));
            array[i] = value;
        }
        return array;
    }

    public static String cleanString(String string){
        return string.replaceAll(" ", "").
                replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(",", "");
    }
}