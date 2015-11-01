package ru.k_kiselev.zilabandroid.encryption;

import ru.k_kiselev.zilabandroid.utils.MathUtils;
import ru.k_kiselev.zilabandroid.utils.StringUtils;

import java.util.Arrays;

public class Encryptor {

    public static String encrypt(String string){
        String completedString = StringUtils.completeString(string);
        int[] inputArray = StringUtils.convertStringToArray(completedString);
        int[] gamma = EncryptionProtocol.gamma;
        int[] sum = MathUtils.sumArrays(inputArray, gamma);
        int[] encryptedInput = MathUtils.shift(sum, EncryptionProtocol.SHIFT);
        return Arrays.toString(encryptedInput);
    }
}
